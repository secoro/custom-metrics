package com.example.custommetrics.service;

import com.example.custommetrics.exception.BookCreationException;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final Counter counter;
    private final Timer timer;

    public BookService(MeterRegistry meterRegistry) {
        counter = Counter.builder("books.created").description("Number of books created").register(meterRegistry);
        timer = Timer.builder("books.creation.time").description("Time taken to create a book").register(meterRegistry);
    }

    public void createBook() {
        try {
            timer.record(() -> {
                try {
                    // Work that simulates the creation of a book
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new BookCreationException("Could not create book", e);
                }
            });
        } finally {
            counter.increment();
        }
    }
}
