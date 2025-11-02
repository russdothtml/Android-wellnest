package com.example.wellnestlayoutjournal;

public class Goal {
    private String username;
    private String goalText;
    private int imageResId; // 0 if no image


    public Goal(String username, String goalText, int imageResId) {
        this.username = username;
        this.goalText = goalText;
        this.imageResId = imageResId;
    }


    public String getUsername() {
        return username;
    }


    public String getGoalText() {
        return goalText;
    }


    public int getImageResId() {
        return imageResId;
    }
}

