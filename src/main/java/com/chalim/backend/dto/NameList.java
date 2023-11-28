package com.chalim.backend.dto;

import com.chalim.backend.dto.kakaoapi.Document;
import java.util.List;

public class NameList {
    private double latitude;
    private double longitude;
    private List<Document> documents;

    public NameList(double latitude, double longitude, List<Document> documents) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.documents = documents;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "NameList{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", documents=" + documents +
                '}';
    }
}