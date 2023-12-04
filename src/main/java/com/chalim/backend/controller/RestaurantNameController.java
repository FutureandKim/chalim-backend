package com.chalim.backend.controller;

import com.chalim.backend.dto.NameList;
import com.chalim.backend.service.RestaurantNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RestaurantNameController {

    private final Logger logger = LoggerFactory.getLogger(RestaurantNameController.class);

    @Autowired
    RestaurantNameService restaurantNameService;


    //에러 처리 하기!!
    @PostMapping("/restaurant-name")
    public ResponseEntity<NameList> searchRestaurantByKeywordPost(
            @RequestBody Map<String, Object> requestBody) throws Exception {

        // from frontend
        String keyword = (String) requestBody.get("keyword");
        double latitude = (double) requestBody.get("y");
        double longitude = (double) requestBody.get("x");
        int radius = requestBody.containsKey("radius") ? (int) requestBody.get("radius") : 1000; //반경 100m

        logger.info("/restaurant-name-post(가게명 조회 - POST) keyword [{}], latitude [{}], longitude [{}], radius [{}]", keyword, latitude, longitude, radius);

        NameList list = restaurantNameService.searchRestaurantByKeyword(keyword, latitude, longitude, radius);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
