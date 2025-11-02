package com.example.wellnestlayoutjournal;

public class JournalEntry {
    private final String date;
    private final String title;
    private final String mood;
    private final int color;

    public JournalEntry(String date, String title, String mood, int color) {
        this.date = date;
        this.title = title;
        this.mood = mood;
        this.color = color;
    }

    public String getDate() { return date; }
    public String getTitle() { return title; }
    public String getMood() { return mood; }
    public int getColor() { return color; }
}
