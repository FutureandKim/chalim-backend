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

    @GetMapping("/search")
    public ResponseEntity<NameList> searchPlaceByKeyword(@RequestParam("keyword") String keyword, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("userId") String userId) throws Exception {

        logger.info(" /search api start. user [{}], keyword [{}], page [{}], size [{}]", userId, keyword, page, size);

        NameList list = restaurantNameService.searchPlaceByKeyword(keyword, page, size, userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
