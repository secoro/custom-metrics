package com.example.custommetrics.controller;

import com.example.custommetrics.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public void createBook() {
        log.info("Creating a book");
        bookService.createBook();
    }
}
