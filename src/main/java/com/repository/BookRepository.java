package com.repository;

import com.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    Logger logger = LoggerFactory.getLogger(BookRepository.class);
    private  List <Book> bookList = new ArrayList<>();

    public boolean addBook(Book book){
        bookList.add(book);
        logger.info("Add Book {} {} {}",book.getBookName(),book.getAuthor(), book.getIsbn());
        return true;
    }

    public List <Book> getBookList(){
        return this.bookList;
    }
}
