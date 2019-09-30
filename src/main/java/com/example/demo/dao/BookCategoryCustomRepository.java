package com.example.demo.dao;

import com.example.demo.model.BookCategory;

import java.util.List;

public interface BookCategoryCustomRepository {

    List<BookCategory> getCategoriesWithWordInTitle(String word);
}
