package com.service;
import com.model.Book;
import com.repository.BookRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class BookExcelService {
    @Autowired
    BookRepository bookRepository;

    Logger logger = LoggerFactory.getLogger(BookRepository.class);

    public boolean bookToExcel ()  {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("BookExcel");
        int rowNum = 0;
        List<Book> books = bookRepository.getBookList();
        for(Book book : books) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(book.getBookName());
            row.createCell(1).setCellValue(book.getAuthor());
            row.createCell(2).setCellValue(book.getAuthor());
        }

        try{
            FileOutputStream fileOut = new FileOutputStream("data/book.xlsx");
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        
        return true;
    }


}
