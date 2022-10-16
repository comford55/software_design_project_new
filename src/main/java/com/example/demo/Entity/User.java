// package com.example.demo.Entity;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name="user")
// public class User {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     @Column(name="id")
//     private Integer id;
//     @Column(name="username", unique=true, nullable=true)
//     private String username;
//     @Column(name="email", unique=true, nullable=true)
//     private String email;
//     @Column(name="password", nullable=true)
//     private String password;
    
//     // private Gag gag;
    
//     // public User(Integer id, String name) {
//     //     super();
//     //     this.id = id;
//     //     this.name = name;
//     // }

//     public User() {

//     }

//     public Integer getId() {
//         return this.id;
//     }

//     public void setId(Integer id) {
//         this.id = id;
//     }

//     public String getUsername() {
//         return this.username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     // public Gag getGag() {
//     //     return this.gag;
//     // }

//     // public void setGag(Gag gag) {
//     //     this.gag = gag;
//     // }

//     public String getEmail() {
//         return this.email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return this.password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public User(Integer id, String username, String email, String password) {
//         super();
//         this.id = id;
//         this.username = username;
//         this.email = email;
//         this.password = password;
//     }

//     public User(String username, String email, String password) {
//         super();
//         this.username = username;
//         this.email = email;
//         this.password = password;
//     }
// }
