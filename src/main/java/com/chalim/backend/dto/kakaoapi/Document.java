package com.chalim.backend.dto.kakaoapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    private String id;

    @JsonProperty("place_name")
    private String placeName;

    @JsonProperty("category_name")
    private String categoryName;

    private String x;
    private String y;
    private String distance;

    @JsonProperty("redirect_url")
    @JsonIgnoreProperties(ignoreUnknown=true)
    private String redirectUrl;


    public String getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }


    public String getDistance() {
        return distance;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }


    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public String toString() {
        return "Document{" +
                "placeName='" + placeName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", distance='" + distance + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}