package com.example.book_market_service.dto;

import lombok.Data;

@Data
public class BookDto {
    private long id;
    private String bookName;
    private long authorId;
    private String email;
    private String userName;
}
