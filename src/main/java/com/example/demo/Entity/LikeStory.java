package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="likeStory")
public class LikeStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // private String storyId;
    private int count;

    @OneToOne
    @JoinColumn(name = "id_story")
    private Story story;

    public LikeStory(Story story) {
        this.story = story;
    }

    public LikeStory(String storyId) {
        // this.storyId = storyId;
        this.count = 0;
    }

    public LikeStory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void increaseCount(){
        this.count++;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
