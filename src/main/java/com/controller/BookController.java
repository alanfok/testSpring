package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.model.Book;
import com.repository.BookRepository;
import com.service.BookExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BookExcelService bookExcelService;

    @GetMapping("getBook")
    public String getBook(){
        System.out.println("fdfa");
        return "fdfadsfsa";
    }

    @PostMapping("addBook")
    public String addBook(@RequestBody Book book){
        if(bookRepository.addBook(book)){
            return "add book success";
        };
        return "fail to add book";
    }

    @GetMapping("getBooks")
    public String getBooks() throws JsonProcessingException {
        List <Book> books = bookRepository.getBookList();
        return objectMapper.writeValueAsString(books);
    }

    @GetMapping("getBooksExcel")
    public String getBooksExcel() {
        boolean ret = false;
        try {
            ret = bookExcelService.bookToExcel();
        }catch (Exception e){
            ret = false;
        }
        if(ret){
            return "This excel is created";
        }
        return "This excel is created is failed to create";
    }

    @GetMapping("testConnection")
    public String testConnection(){
        return "it's connencted";
    }

}
