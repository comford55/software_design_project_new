package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String name;

    // private Gag gag;
    
    public User(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public User() {

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Gag getGag() {
    //     return this.gag;
    // }

    // public void setGag(Gag gag) {
    //     this.gag = gag;
    // }
}
