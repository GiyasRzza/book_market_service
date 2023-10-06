package com.example.book_market_service.controller;

import com.example.book_market_service.dao.AuthorDao;
import com.example.book_market_service.dto.AuthorDto;
import com.example.book_market_service.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthorController {
    private final AuthorService authorService;
    @PostMapping("save-author")
    public void  createAuthor(@RequestBody AuthorDto authorDto){
        log.info(String.valueOf(authorDto));
     authorService.createAuthor(authorDto);
    }

    @GetMapping("get-author")
    public AuthorDao getAuthor(@RequestHeader long id){
        log.info(String.valueOf(id));
       return authorService.findAuthor(id);
    }

}
