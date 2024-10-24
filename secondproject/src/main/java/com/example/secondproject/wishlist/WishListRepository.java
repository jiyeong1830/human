package com.example.secondproject.wishlist;

import com.example.secondproject.utils.StringUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WishListRepository {
    // List 자바메모리 wish정보
    private List<WishListVO> wishListVOList = new ArrayList<>();

    public List<WishListVO> wishSave(WishListDto wishListDto) {
        // wishListDto -> wishListVO로 변환
        WishListVO wishListVO = new WishListVO();

        wishListVO.setId(wishListVOList.size() + 1);
        wishListVO.setTitle(StringUtils.removeTags(wishListDto.getTitle()));
        wishListVO.setCategory(wishListDto.getCategory());
        wishListVO.setJibunAddress(wishListDto.getJibunAddress());
        wishListVO.setRoadAddress(wishListDto.getRoadAddress());
        wishListVO.setHomepageLink(wishListDto.getHomepageLink());
        wishListVO.setImageLink(wishListDto.getImageLink());

        wishListVO.setVisitIs(false);
        wishListVO.setVisitCount(0);
        wishListVO.setLastVisitDate(null);

        // 나의 위시리스트 메모리 db에 추가 저장
        wishListVOList.add(wishListVO);

        return wishListVOList;
    }

    public List<WishListVO> allWish() {
        return wishListVOList;
    }

    public boolean wishAddVisit(Integer wishId) {
        boolean isAddVisitSuccess = false;

        for (WishListVO wishListVO : wishListVOList) {
            if(wishListVO.getId().equals(wishId)) {
                wishListVO.setVisitIs(true); // 방문함으로 변경
                wishListVO.setVisitCount(wishListVO.getVisitCount() + 1); // 방문횟수 증가
                wishListVO.setLastVisitDate(LocalDateTime.now()); // 방문일자 저장

                isAddVisitSuccess = true;
                break;
            }
        }
        return isAddVisitSuccess;
    }

    public boolean wishDelete(Integer wishId) {
        // id에 해당하는 위시vo를 가져오려고 시도
        Optional<WishListVO> optionalWishListVO
                = wishListVOList.stream()
                .filter(wishListVO -> wishListVO.getId() == wishId)
                .findFirst();

        // 가져온 위시vo값으로 메모리에 있는 wishListVOList안의 값을 삭제
        return optionalWishListVO.isPresent() ? wishListVOList.remove(optionalWishListVO.get()) : false;
    }
}
