package com.example.wellnestlayoutjournal;

public class JournalItem {
    private String title;
    private String content;
    private String date;
    private String mood;

    // Correct constructor name to match class
    public JournalItem(String title, String content, String date, String mood) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.mood = mood;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getDate() { return date; }
    public String getMood() { return mood; }

    // Optional setters (only if you want to update later)
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setDate(String date) { this.date = date; }
    public void setMood(String mood) { this.mood = mood; }
}
