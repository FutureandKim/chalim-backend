package com.chalim.backend.dto.kakaoapi;

public class RestaurantNameRequest {
    private double y;
    private double x;
    private int radius;
    private String query;


    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = (double) y;
    }

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = (double) x;
    }

    public Object getRadius() {
        return radius;
    }

    public void setRadius(Object radius) {
        this.radius = (int) radius;
    }

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = (String) query;
    }
}
