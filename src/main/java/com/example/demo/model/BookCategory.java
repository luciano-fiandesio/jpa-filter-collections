package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookCategory {

    public BookCategory() {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCategory(String name) {
        this.name = name;
    }
}
