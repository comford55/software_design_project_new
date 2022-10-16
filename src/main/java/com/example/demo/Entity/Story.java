package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="storyDetail", length = 1000000)
    private String storyDetail;
    @Column(name="author")
    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    private List<Category> category = new ArrayList<Category>();

    public Story() {
        
    }

    public Story(String title, String storyDetail, String author) {
        super();
        this.title = title;
        this.storyDetail = storyDetail;
        this.author = author;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Category> getCategory() {
        return this.category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
