package com.example.book_market_service.service;

import com.example.book_market_service.dao.AuthorDao;
import com.example.book_market_service.dto.AuthorDto;
import com.example.book_market_service.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthorService {
  private final AuthorRepository authorRepository;




    public AuthorDao findAuthor(long id){

    return  authorRepository.findWithQueryAuthor(id);
  }

  public void createAuthor(AuthorDto  authorDto){
    AuthorDao authorDao =AuthorDao.builder().
            authorName(authorDto.getAuthorName()).
            build();
    authorRepository.save(authorDao);
  }



}
