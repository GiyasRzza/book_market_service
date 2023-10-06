package com.example.book_market_service.service;

import com.example.book_market_service.dao.AuthorDao;
import com.example.book_market_service.dao.BookDao;
import com.example.book_market_service.dto.BookDto;
import com.example.book_market_service.mapper.UserMapper;
import com.example.book_market_service.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
   private final BookRepository bookRepository;
   private final  AuthorService  authorService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

   public BookDto saveBook(BookDto bookDto){
      AuthorDao authorDao =  authorService.findAuthor(bookDto.getAuthorId());
//           BookDao bookDao = BookDao.builder()
//                   .bookName(bookDto.getBookName())
//                   .author(authorDao)
//                   .build();
//      bookRepository.save(bookDao);
       BookDao bookDao = userMapper.daoToDto(bookDto);
       bookDao.setAuthor(authorDao);
       bookRepository.save(bookDao);
      return bookDto;

   }

   public List<BookDto> getAllBook(){
        return userMapper.listDaoToDto(bookRepository.findAll());

   }
    public BookDto daoConverseDto(BookDao bookDao){
        return userMapper.dtoToDao(bookDao);
    }

}
