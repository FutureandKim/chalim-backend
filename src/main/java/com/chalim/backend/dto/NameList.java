package com.chalim.backend.dto;

import com.chalim.backend.dto.kakaoapi.Document;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameList {
    private List<Document> documents;

    public NameList(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "NameList{" +
                "documents=" + documents +
                '}';
    }



}