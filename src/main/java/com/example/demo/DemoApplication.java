package com.example.demo;

import com.example.demo.dao.BookCategoryDaoImpl;
import com.example.demo.dao.BookCategoryRepository;
import com.example.demo.model.Book;
import com.example.demo.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private BookCategoryDaoImpl bookCategoryDao;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) {
        // Create a couple of Book and BookCategory
        bookCategoryRepository.save(new BookCategory("Science Fiction",
                new Book("Three Body Problem"),
                new Book("Snow Crash"),
                new Book("Solaris"),
                new Book("Body Shop"),
                new Book("The Forever War")));

        List<BookCategory> bcs = bookCategoryDao.getCategoriesWithWordInTitle("Body");

        for (BookCategory bc : bcs) {
            System.out.println("category: " + bc.getName());
            Set<Book> books = bc.getBooks();
            for (Book book : books) {
                System.out.println(book.getName());
            }
        }
    }
}
