package com.example.demo.dao;

import com.example.demo.model.Book;
import com.example.demo.model.BookCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.PluralAttribute;
import java.util.List;

@Repository
public class BookCategoryDaoImpl implements BookCategoryCustomRepository {

    @PersistenceContext
    private EntityManager em;

    public List<BookCategory> getCategoriesWithWordInTitle(String word) {

        String hql = "select distinct bc from BookCategory as bc JOIN FETCH bc.books as b where b.name like :word";
        Query query = em.createQuery(hql);
        query.setParameter("word", "%" + word + "%");
        return query.getResultList();

    }
}
