package com.chalim.backend.service;
import com.chalim.backend.dto.NaverApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReviewService {

    @Value("${naver.api.client-id}")
    private String clientId;

    @Value("${naver.api.client-secret}")
    private String clientSecret;

    private final NaverApi naverApi;

    public ReviewService(NaverApi naverApi) {
        this.naverApi = naverApi;
    }

    public String searchReview(String query) {
        String encodedQuery = encodeQuery(query);
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + encodedQuery;

        Map<String, String> requestHeaders = createRequestHeaders();

        return naverApi.get(apiURL, requestHeaders);
    }

    private String encodeQuery(String query) {
        try {
            return URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패", e);
        }
    }

    private Map<String, String> createRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Naver-Client-Id", clientId);
        headers.put("X-Naver-Client-Secret", clientSecret);
        return headers;
    }
}
