package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GagDetail {
    @JsonProperty("gagId")
    private String id;
    @JsonProperty("gagDetail")
    private String gagDetail;
    @JsonProperty("author")
    private String author;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGagDetail() {
        return this.gagDetail;
    }

    public void setGagDetail(String gagDetail) {
        this.gagDetail = gagDetail;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public GagDetail(String id, String gagDetail, String author) {
        this.id = id;
        this.gagDetail = gagDetail;
        this.author = author;
    }

    public GagDetail() {

    }

}
