package com.library.LibraryManagement_SpringBoot.entity;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    // Default constructor - MUST have
    public Book() {}

    // Optional constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and setters — VERY important for JSON binding!

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // Usually setter for id is optional, but good to have
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
