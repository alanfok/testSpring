package com.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Book {
    private String bookName;
    private String author;
    private String isbn;

    public Book(String bookName, String author, String isbn) {
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
    }
}
