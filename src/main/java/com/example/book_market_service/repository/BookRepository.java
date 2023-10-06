package com.example.book_market_service.repository;

import com.example.book_market_service.dao.BookDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookDao, Long> {

             List<BookDao> findAll();
}
