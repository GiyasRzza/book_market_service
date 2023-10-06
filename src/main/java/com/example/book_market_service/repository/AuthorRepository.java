package com.example.book_market_service.repository;

import com.example.book_market_service.dao.AuthorDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorDao,Long> {
    @Query(value = "select * from AuthorDao where id = :id",nativeQuery = true)
    AuthorDao findWithQueryAuthor(@Param("id") long id);
}
