package com.chalim.backend.dto.kakaoapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    @JsonProperty("place_name")
    private String placeName;

    public String getPlaceName() {
        return placeName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "placeName='" + placeName +
                '}';
    }
}
