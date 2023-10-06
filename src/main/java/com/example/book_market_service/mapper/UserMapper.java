package com.example.book_market_service.mapper;

import com.example.book_market_service.dao.BookDao;
import com.example.book_market_service.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //@Mapping(source = "email", target = "userName") // Map email to username
    BookDao daoToDto(BookDto dao);
    //@Mapping(source = "userName", target = "email")
    BookDto dtoToDao(BookDao dto);
    List<BookDto> listDaoToDto(List<BookDao> bookDaos);
}
