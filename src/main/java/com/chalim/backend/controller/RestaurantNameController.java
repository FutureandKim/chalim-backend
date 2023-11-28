package com.chalim.backend.controller;

import com.chalim.backend.dto.NameList;
import com.chalim.backend.dto.kakaoapi.RestaurantNameRequest;
import com.chalim.backend.dto.kakaoapi.RestaurantNameResponse;
import com.chalim.backend.service.RestaurantNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantNameController {

    private final Logger logger = LoggerFactory.getLogger(RestaurantNameController.class);


    @Autowired
    RestaurantNameService restaurantNameService;

    @GetMapping("/restaurant-name")
    public ResponseEntity<NameList> searchPlaceByKeyword(
            @RequestParam("keyword") String keyword,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam(name = "radius", defaultValue = "100") int radius) throws Exception {

        logger.info("/restaurant-name api(가게명 검색 api) keyword [{}], page [{}], size [{}], latitude [{}], longitude [{}], radius [{}]", keyword, page, size, latitude, longitude, radius);

        NameList list = restaurantNameService.searchPlaceByKeyword(keyword, page, size, latitude, longitude, radius);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
