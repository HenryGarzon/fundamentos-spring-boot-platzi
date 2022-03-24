package com.fundamentosplatzi.sprinboot.fundamentos.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_user", nullable = false, unique = true)
    private Long id;

    @Column(length = 50)
    private String name1;

    @Column(length = 50, unique = true)
    private String email;

    private LocalDate birdDate;

    @OneToMany(mappedBy = "user", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post>  posts =new ArrayList<>();

    public User() {
    }



    public User(String name1, String email, LocalDate birdDate) {
        this.name1=name1;
        this.email=email;
        this.birdDate=birdDate;
    }

    public User(Long id) {
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirdDate() {
        return birdDate;
    }

    public void setBirdDate(LocalDate birdDate) {
        this.birdDate = birdDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                ", email='" + email + '\'' +
                ", birdDate=" + birdDate +
                ", posts=" + posts +
                '}';
    }
}