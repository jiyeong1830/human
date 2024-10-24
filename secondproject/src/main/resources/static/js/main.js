//console.log('hello~');

// 화면결과용의 Vue 객체 생성
var searchResult = new Vue({
    el: '#search-result',
    data: {
        search_result: {},
    },
});

// 위시리스트 결과용의 Vue 객체 생성
var wishListResult = new Vue({
    el: '#wish-list-result',
    data: {
        wish_list: {},
    },
    methods: {
        deleteWishList(wishId) {
            console.log('wishlist delete wishId', wishId);

            // 위시리스트 삭제 요청하기
            $.ajax({
                type: 'post',
                url: '/api/wishdelete/' + wishId,
                success: function(response, status, xhr) {
                    console.log('위시리스트 삭제 완료', response);   // WishListVO

                    // 위시리스트 목록 가져오기
                    $.get('/api/wishall', function(response) {
                        wishListResult.wish_list = response;
                    });
                },
                error: function(request, status, error) {
                    alert('위시리스트 추가가 실패하였습니다');
                },
            });
        },
        addVisitCount(wishId) {
            // 방문 횟수 증가하기
            console.log('add visit count wishId', wishId);

            $.ajax({
                type: 'post',
                url: '/api/wishvisit/' + wishId,
                success: function(response, status, xhr) {
                    console.log('방문수 증가 완료', response);   // WishListVO
                    //alert('방문수 증가가 성공하였습니다');

                    // 위시리스트 목록 가져오기
                    $.get('/api/wishall', function(response) {
                        wishListResult.wish_list = response;
                    });
                },
                error: function(request, status, error) {
                    alert('방문수 증가가 실패하였습니다');
                },
            });
        }
    },
});

// 검색 버튼을 눌렀을 때 이벤트
$('#searchButton').click(function() {
    console.log('search btn click');

    const query = $('#searchBox').val();

    // 실제 backend에 /api/search 요청해서 데이터 가져오기(ajax)
    $.get('/api/search?searchQuery=' + query, function(response) {
        console.log('search response값', response);

        searchResult.search_result = response;
        const title = document.getElementById('wish-title');
        if (title)
            title.innerHTML = searchResult.search_result.title.replace(/<^>]*>?/g, '');

        $('#search-result').show();
    });
});

// 검색창에서 enter키를 눌렀을 시 이벤트 처리
$('#searchBox').on('keyup', function(event) {
    if (event.keyCode == 13) { // 13번은 enter
        console.log('enter key press');

        $('#searchButton').click();
    }
});

// 위시리스트 추가 버튼을 눌렀을 때
$('#wish-button').click(function() {
    console.log('wish btn click');

    // ajax 비동기로 위시리스트 내용을 post로 요청
    $.ajax({
        type: 'post',           // http method를 post로 요청
        url: '/api/wishadd',    // api url
        contentType: 'application/json',
        data: JSON.stringify(searchResult.search_result),   // Vue객체인 searchResult의 search_result를 json으로 변환
        success: function(response, status, xhr) {
            console.log('위시리스트 추가 완료', response);   // WishListVO

            wishListResult.wish_list = response;  // response는 list로 되어있음
            $('#wish-list-result').show(); // 위시리스트를 보여주기

            //alert('위시리스트 추가가 성공하였습니다');
        },
        error: function(request, status, error) {
            alert('위시리스트 추가가 실패하였습니다');
        },
    });
});

// 처음 페이지 로딩될 시 호출되는 jquery
$(document).ready(function() {
    console.log('jquery ready');

    $('#search-result').hide(); // 검색결과를 숨김
    $('#wish-list-result').hide(); // 위시리스트를 숨김

    // 위시리스트 목록 가져오기
    $.get('/api/wishall', function(response) {
        wishListResult.wish_list = response;

        $('#wish-list-result').show(); // 위시리스트를 보여주기
    });
});
