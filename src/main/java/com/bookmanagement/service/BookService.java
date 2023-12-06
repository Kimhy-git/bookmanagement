package com.bookmanagement.service;

import com.bookmanagement.domain.Book;
import com.bookmanagement.dto.BookRequest;
import com.bookmanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(BookRequest request) {
        return bookRepository.save(Book.builder()
                        .title(request.getTitle())
                        .author(request.getAuthor())
                        .isbn(request.getIsbn())
                        .loan_status(false)
                        .build());
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
    }

    @Transactional
    public Book update(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        book.update(request.getTitle(), request.getAuthor(), request.getPublisher(), request.getIsbn());

        return book;
    }

    @Transactional
    public void updateStatusLoan(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        book.updateStatus(true);
    }

    @Transactional
    public void updateStatusReturn(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        book.updateStatus(false);
    }
}
