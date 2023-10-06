package com.example.book_market_service.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "booksdao")
public class BookDao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bookName;
    private String email;
    private String userName;
    @ManyToOne
    private AuthorDao author;


}
