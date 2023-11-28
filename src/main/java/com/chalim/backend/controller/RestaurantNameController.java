package com.chalim.backend.controller;

import com.chalim.backend.dto.NameList;
import com.chalim.backend.service.RestaurantNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantNameController {

    private final Logger logger = LoggerFactory.getLogger(RestaurantNameController.class);

    @Autowired
    RestaurantNameService restaurantNameService;

    @GetMapping("/restaurant-name")
    public ResponseEntity<NameList> searchRestaurantByKeyword(
            @RequestParam("keyword") String keyword,
            @RequestParam("y") double latitude, //y:위도
            @RequestParam("x") double longitude, //x:경도
            @RequestParam(name = "radius", defaultValue = "50") int radius) throws Exception {

        logger.info("/restaurant-name(가게명 검색 api) keyword [{}], latitude [{}], longitude [{}], radius [{}]", keyword, latitude, longitude, radius);

        NameList list = restaurantNameService.searchRestaurantByKeyword(keyword, latitude, longitude, radius);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
