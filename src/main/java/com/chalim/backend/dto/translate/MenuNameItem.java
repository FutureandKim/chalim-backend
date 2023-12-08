package com.chalim.backend.dto.translate;


public class MenuNameItem {
    private String transcription;
    private int[][] points;

    public MenuNameItem() {
    }

    public MenuNameItem(String transcription, int[][] points) {
        this.transcription = transcription;
        this.points = points;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public int[][] getPoints() {
        return points;
    }

    public void setPoints(int[][] points) {
        this.points = points;
    }
}

