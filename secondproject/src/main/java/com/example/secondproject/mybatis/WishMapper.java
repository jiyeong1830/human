package com.example.secondproject.mybatis;

import com.example.secondproject.wishlist.WishListVO;

import java.util.List;

public interface WishMapper {
    // 1. 위시리스트 전부 가져오기
    List<WishListVO> getWishVOList();
    // 2. 위시리스트 데이터 입력저장하기(return값은 들어간 데이터의 행개수)
    int insertWishVO(WishListVO wishListVO);
    // 3. 방문 추가 처리
    //int updateWishVisit(WishListVO wishListVO);
    int updateWishVisit(int wishId);
    // 4. 위시리스트 데이터 삭제
    int deleteWishList(int wishId);
}
