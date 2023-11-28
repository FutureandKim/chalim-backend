package com.chalim.backend.dto;



import com.chalim.backend.dto.kakaoapi.Document;

import java.util.List;

public class NameList {
    private int currentPage;
    private int totalPage;
    private int size;
    private int pageableCount;
    private List<Document> documents;

    public NameList(int currentPage, int totalPage, int size, int pageableCount, List<Document> documents) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.size = size;
        this.pageableCount = pageableCount;
        this.documents = documents;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getSize() {
        return size;
    }

    public int getPageableCount() {
        return pageableCount;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "PlaceList{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", size=" + size +
                ", pageableCount=" + pageableCount +
                ", documents=" + documents +
                '}';
    }
}