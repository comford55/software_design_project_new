package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryDetail {
    @JsonProperty("title")
    private String title;
    @JsonProperty("storyDetail")
    private String storyDetail;
    @JsonProperty("author")
    private String author;

    private Category category;

    public StoryDetail() {

    }

    public StoryDetail(String title, String storyDetail, String author) {
        this.title = title;
        this.storyDetail = storyDetail;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStoryDetail() {
        return this.storyDetail;
    }

    public void setStoryDetail(String storyDetail) {
        this.storyDetail = storyDetail;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
