package com.example.demo;

import com.example.demo.dao.BookCategoryDaoImpl;
import com.example.demo.dao.BookCategoryRepository;
import com.example.demo.dao.BookRepository;
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
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryDaoImpl bookCategoryDao;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) {
        // Create a couple of Book and BookCategory
        bookRepository.save(new Book("book1",
                new BookCategory("alfa"),
                new BookCategory("beta"),
                new BookCategory("gamma"),
                new BookCategory("gamma1"),
                new BookCategory("gamma2"),
                new BookCategory("delta")));
        bookRepository.save(new Book("book2",
                new BookCategory("beta"),
                new BookCategory("gamma"),
                new BookCategory("gamma1"),
                new BookCategory("delta")));
        bookRepository.save(new Book("book3",
                new BookCategory("alfa"),
                new BookCategory("gamma"),
                new BookCategory("gamma1"),
                new BookCategory("gamma3")));

        // no result
        debug(bookCategoryDao.getBooksWithCategory( "omega"));
        // 2 books
        debug(bookCategoryDao.getBooksWithCategory( "alfa"));
        // 3 books
        debug(bookCategoryDao.getBooksWithCategory( "gamma"));


    }

    private void debug(List<Book> books) {
        for (Book book : books) {
            System.out.println("book: " + book.getName());
            Set<BookCategory> cat = book.getBookCategory();
            for (BookCategory bookCategory : cat) {
                System.out.println("\tcategory: " + bookCategory.getName());
            }
        }

    }
}
