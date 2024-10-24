package com.example.secondproject.controller;

import com.example.secondproject.wishlist.WishListDto;
import com.example.secondproject.wishlist.WishListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.secondproject.wishlist.WishListService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private WishListService wishListService;

    // 1. 검색 API(GET)
    @GetMapping("/search")
    public WishListDto search(@RequestParam String searchQuery) {
        WishListDto wishListDto = wishListService.search(searchQuery);

        return wishListDto;
    }

    // 2. 위시리스트 추가 API(POST)
    @PostMapping("/wishadd")
    // json받아야 하기 때문에
    public List<WishListVO> wishAdd(@RequestBody WishListDto wishListDto) {
        return wishListService.addWishFromMapper(wishListDto);
//        return wishListService.addWishFromJpa(wishListDto);
    }

    // 3. 위시리스트 목록 가져오기 API(GET)
    @GetMapping("/wishall")
    public List<WishListVO> wishAll() {
        return wishListService.allWishFromMapper();
//        return wishListService.allWishFromJpa();
    }

    // 4. 방문 추가 API
    @PostMapping("/wishvisit/{wishId}")
    public boolean wishVisit(@PathVariable("wishId") Integer wishId) {
        return wishListService.addVisitWishFromMapper(wishId);
        //return wishListService.addVisitWish(wishId);
    }

    // 5. 위시리스트 삭제 API
    @PostMapping("/wishdelete/{wishId}")
    public boolean wishDelete(@PathVariable("wishId") Integer wishId) {
        return wishListService.deleteWishFromMapper(wishId);
        //return wishListService.deleteWish(wishId);
    }
}
