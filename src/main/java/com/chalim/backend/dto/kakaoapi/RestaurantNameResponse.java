package com.chalim.backend.dto.kakaoapi;

import java.util.List;

public class RestaurantNameResponse {
    private Meta meta;
    private List<Document> documents;

    public Meta getMeta() {
        return meta;
    }
    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "KakaoResponse{" +
                "meta=" + meta +
                ", documents=" + documents +
                '}';
    }
}
