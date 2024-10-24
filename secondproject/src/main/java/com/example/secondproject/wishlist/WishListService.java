package com.example.secondproject.wishlist;

import com.example.secondproject.jpa.Wish;
import com.example.secondproject.jpa.WishRepository;
import com.example.secondproject.mybatis.WishMapper;
import com.example.secondproject.naver.NaverAPIClient;
import com.example.secondproject.naver.dto.SearchImageRequestDto;
import com.example.secondproject.naver.dto.SearchImageResponseDto;
import com.example.secondproject.naver.dto.SearchRegionRequestDto;
import com.example.secondproject.naver.dto.SearchRegionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {
    @Autowired
    private NaverAPIClient naverAPIClient;

    @Autowired
    private WishListRepository wishListRepository;  // 자바 메모리로 crud

    @Autowired
    private WishRepository wishRepository;  // jpa를 이용해서 rdb에 있는 wish테이블을 crud

    @Autowired
    private WishMapper wishMapper;

    // Naver API를 호출
    public WishListDto search(String paramQuery) {
        WishListDto wishListDto = new WishListDto();

        // 1. NaverAPI 지역검색 호출해서 dto 값 매핑 코드
        SearchRegionRequestDto searchRegionRequestDto = new SearchRegionRequestDto();
        searchRegionRequestDto.setQuery(paramQuery);

        SearchRegionResponseDto searchRegionResponseDto = naverAPIClient.searchRegion(searchRegionRequestDto);
        // searchRegionResponseDto -> wishListDto에 매핑
        List<SearchRegionResponseDto.SearchRegionItem> searchRegionItemList = searchRegionResponseDto.getItems();
        if (searchRegionItemList != null && searchRegionItemList.size() > 0) {
            SearchRegionResponseDto.SearchRegionItem searchRegionItem = searchRegionItemList.get(0);

            wishListDto.setTitle(searchRegionItem.getTitle());
            wishListDto.setCategory(searchRegionItem.getCategory());
            wishListDto.setJibunAddress(searchRegionItem.getAddress());
            wishListDto.setRoadAddress(searchRegionItem.getRoadAddress());
            wishListDto.setHomepageLink(searchRegionItem.getLink());
        }

        // 2. NaverAPI 이미지검색 호출해서 dto값 매핑 코드
        SearchImageRequestDto searchImageRequestDto = new SearchImageRequestDto();
        searchImageRequestDto.setQuery(paramQuery);

        SearchImageResponseDto searchImageResponseDto = naverAPIClient.searchImage(searchImageRequestDto);
        // searchImageResponseDto -> wishListDto에 매핑
        List<SearchImageResponseDto.SearchImageItem> searchImageItemList = searchImageResponseDto.getItems();
        if (searchImageItemList != null && searchImageItemList.size() > 0) {
            SearchImageResponseDto.SearchImageItem searchImageItem = searchImageItemList.get(0);

            wishListDto.setImageLink(searchImageItem.getLink());
        }
        return wishListDto;
    }

    public List<WishListVO> addWishFromMapper(WishListDto wishListDto) {
        WishListVO wishListVO = new WishListVO();
        wishListVO.setTitle(wishListDto.getTitle());
        wishListVO.setCategory(wishListDto.getCategory());
        wishListVO.setJibunAddress(wishListDto.getJibunAddress());
        wishListVO.setRoadAddress(wishListDto.getRoadAddress());
        wishListVO.setHomepageLink(wishListDto.getHomepageLink());
        wishListVO.setImageLink(wishListDto.getImageLink());

        wishListVO.setVisitIs(false);
        wishListVO.setVisitCount(0);
        wishListVO.setLastVisitDate(LocalDateTime.now());

        // 실제 DB에 저장입력
        wishMapper.insertWishVO(wishListVO);

        // 다시 위시리스트 전체 조회
        return allWishFromMapper();
    }

    public List<WishListVO> addWishFromJpa(WishListDto wishListDto) {
        // dto -> entity로 변경: parameter로 받은 dto를 entity로 변경
        Wish wish = new Wish();
        wish.setTitle(wishListDto.getTitle());
        wish.setCategory(wishListDto.getCategory());
        wish.setJibunAddress(wishListDto.getJibunAddress());
        wish.setRoadAddress(wishListDto.getRoadAddress());
        wish.setHomepageLink(wishListDto.getHomepageLink());
        wish.setImageLink(wishListDto.getImageLink());

        wish.setVisitIs(false);
        wish.setVisitCount(0);
        wish.setLastVisitDate(null);

        // 실제 DB에 입력저장
        Wish newWish = wishRepository.save(wish);

        List<WishListVO> wishListVOList = new ArrayList<>();
        List<Wish> wishEntityList = wishRepository.findAll();
        // entity -> vo로 변경: 만들어진 table의 데이터인 entity의 리스트를 vo 리스트로 변경
        for(Wish copyWish : wishEntityList) {
            WishListVO wishListVO = new WishListVO();

            wishListVO.setId(copyWish.getId());
            wishListVO.setTitle(copyWish.getTitle());
            wishListVO.setCategory(copyWish.getCategory());
            wishListVO.setJibunAddress(copyWish.getJibunAddress());
            wishListVO.setRoadAddress(copyWish.getRoadAddress());
            wishListVO.setHomepageLink(copyWish.getHomepageLink());
            wishListVO.setImageLink(copyWish.getImageLink());

            wishListVO.setVisitIs(copyWish.getVisitIs());
            wishListVO.setVisitCount(copyWish.getVisitCount());
            wishListVO.setLastVisitDate(copyWish.getLastVisitDate());

            wishListVOList.add(wishListVO); // 만들어진 wishListVO변수를 wishListVOList에 추가
        }

        return wishListVOList;

        // Storage(DB, Memory etc)에 위시정보 저장
        //return wishListRepository.wishSave(wishListDto);
    }

    // wish storage의 모든 데이터 가져오기(mybatis)
    public List<WishListVO> allWishFromMapper() {
        List<WishListVO> wishListVOList = wishMapper.getWishVOList();

        return wishListVOList;
    }

    // wish storage의 모든 데이터 가져오기(jpa)
    public List<WishListVO> allWishFromJpa() {
        List<WishListVO> wishListVOList = new ArrayList<>();
        List<Wish> wishEntityList = wishRepository.findAll();
        // entity -> vo로 변경: 만들어진 table의 데이터인 entity의 리스트를 vo 리스트로 변경
        for(Wish copyWish : wishEntityList) {
            WishListVO wishListVO = new WishListVO();

            wishListVO.setId(copyWish.getId());
            wishListVO.setTitle(copyWish.getTitle());
            wishListVO.setCategory(copyWish.getCategory());
            wishListVO.setJibunAddress(copyWish.getJibunAddress());
            wishListVO.setRoadAddress(copyWish.getRoadAddress());
            wishListVO.setHomepageLink(copyWish.getHomepageLink());
            wishListVO.setImageLink(copyWish.getImageLink());

            wishListVO.setVisitIs(copyWish.getVisitIs());
            wishListVO.setVisitCount(copyWish.getVisitCount());
            wishListVO.setLastVisitDate(copyWish.getLastVisitDate());

            wishListVOList.add(wishListVO); // 만들어진 wishListVO변수를 wishListVOList에 추가
        }

        return wishListVOList;

        //return wishListRepository.allWishFromJpa();
    }

    public boolean addVisitWish(Integer wishId) {
        boolean isAddVisit = false;

        // 1. wishId로 DB에 저장된 wish의 원래값을 가져온다.
        Wish wish = wishRepository.findById(wishId).orElse(null);

        if (wish != null) {
            // 2. 방문에 대한 정보 컬럼들을 update한다.
            wish.setVisitCount(wish.getVisitCount() + 1);
            wish.setVisitIs(true);
            wish.setLastVisitDate(LocalDateTime.now());

            try {
                // 3. 실제 DB에 방문정보를 update한다.
                wishRepository.save(wish);
                isAddVisit = true;
            } catch (Exception e) {
                System.out.println("addVisitWish exception: " + e.getMessage());
            }
        }

        return isAddVisit;
        //return wishListRepository.wishAddVisit(wishId);
    }

    public boolean deleteWish(Integer wishId) {
        boolean isDeleteWish = false;

        // 1. wishId로 DB에 저장된 wish의 원래값을 가져온다.
        Wish wish = wishRepository.findById(wishId).orElse(null);

        if (wish != null) {
            wishRepository.delete(wish);
            isDeleteWish = true;
        }

        return isDeleteWish;
        //return wishListRepository.wishDelete(wishId);
    }

    public boolean addVisitWishFromMapper(Integer wishId) {
        return wishMapper.updateWishVisit(wishId) > 0 ? true : false;
    }

    public boolean deleteWishFromMapper(Integer wishId) {
        return wishMapper.deleteWishList(wishId) > 0 ? true : false;
    }

}
