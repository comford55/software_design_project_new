package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gag")
public class Gag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gagId;

    public String getGagId() {
        return this.gagId;
    }

    public void setGagId(String gagId) {
        this.gagId = gagId;
    }

    private String gagDetail;
    private String author;

    // private User user;

    public Gag(Integer id , String gagId,String gagDetail, String author) {
        super();
        this.id = id;
        this.gagId = gagId;
        this.gagDetail = gagDetail;
        this.author = author;
    }

    public Gag(String gagId, String gagDetail, String author) {
        this.gagId = gagId;
        this.gagDetail = gagDetail;
        this.author = author;
    }

    public Gag() {
        
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    // public User getUser() {
    //     return this.user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

}
