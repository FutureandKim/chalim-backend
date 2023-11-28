package com.chalim.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.chalim.backend.config.Constants;
import com.chalim.backend.dto.NameList;
import com.chalim.backend.dto.kakaoapi.RestaurantNameResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
public class RestaurantNameService {

    private final Logger logger = LoggerFactory.getLogger(RestaurantNameService.class);

    private static final String QUERY = "query";
    private static final String AUTHORIZATION = "Authorization";
    private static final String KAKAO_APP_KEY_PREFIX = "KakaoAK ";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public RestaurantNameService(@Qualifier("appRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    public NameList searchRestaurantByKeyword(String keyword, double latitude, double longitude, int radius) throws IOException {

        //logger.info(" 카카오 api key [{}]", kakaoApiKey);

        //헤더
        HttpHeaders headers = new HttpHeaders();
        headers.set(AUTHORIZATION, KAKAO_APP_KEY_PREFIX + kakaoApiKey);

        // uri
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(Constants.KAKAO_SEARCH_API)
                .path(Constants.KAKAO_SEARCH_PATH)
                .queryParam(QUERY, keyword)
                .queryParam("y", latitude)
                .queryParam("x", longitude)
                .queryParam("radius", radius)
                .build();

        // request
        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                uriComponents.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        ObjectMapper mapper = new ObjectMapper();
        RestaurantNameResponse restaurantNameResponse = mapper.readValue(response.getBody(), RestaurantNameResponse.class);

        // redirectUrl setting
        restaurantNameResponse.getDocuments().forEach(document -> {
            document.setRedirectUrl(Constants.MAP_REDIRECT_URL + document.getId());
        });

        // output setting
        NameList nameList = new NameList(latitude, longitude, restaurantNameResponse.getDocuments());

        return nameList;
    }
}
