package com.chalim.backend.dto.translate;

public class TextData {
    private String transcription;
    private int[][] points;

    // Default constructor
    public TextData() {
    }

    // All-args constructor
    public TextData(String transcription, int[][] points) {
        this.transcription = transcription;
        this.points = points;
    }

    // Getters and setters
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
