package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "bookCategory")
@Entity
public class Book {

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookCategory> bookCategory;

    public Book(String name, BookCategory ... categories) {
        this.name = name;
        this.bookCategory = Stream.of(categories).collect(Collectors.toSet());
        this.bookCategory.forEach(x -> x.setBook(this));
    }


}
