package com.chalim.backend.dto.translate;

public class PriceItem {
    private Integer priceValue;
    private int[][] points;

    public PriceItem() {
    }

    public PriceItem(Integer priceValue, int[][] points) {
        this.priceValue = priceValue;
        this.points = points;
    }

    public Integer getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Integer priceValue) {
        this.priceValue = priceValue;
    }

    public int[][] getPoints() {
        return points;
    }

    public void setPoints(int[][] points) {
        this.points = points;
    }
}
