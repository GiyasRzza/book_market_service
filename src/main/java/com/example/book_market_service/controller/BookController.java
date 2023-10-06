package com.example.book_market_service.controller;


import com.example.book_market_service.dao.BookDao;
import com.example.book_market_service.dto.BookDto;
import com.example.book_market_service.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("save-book")
    public BookDto createBook(@RequestBody BookDto bookDto){
        return bookService.saveBook(bookDto);
    }
    @GetMapping("all-book")
    public List<BookDto> getAllBook(){
      return   bookService.getAllBook();
    }
    @PostMapping("get-test") BookDto saveTest(@RequestBody BookDao bookDto){
        return  bookService.daoConverseDto(bookDto);
    }

}
