package com.bookmanagement.controller;

import com.bookmanagement.domain.Book;
import com.bookmanagement.dto.BookLoanResponse;
import com.bookmanagement.dto.BookRequest;
import com.bookmanagement.dto.BookResponse;
import com.bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookApiController {

    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody BookRequest request) {
        Book addedBook = bookService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addedBook);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponse> findBook(@PathVariable Long id) {
        Book book = bookService.findById(id);

        return ResponseEntity.ok()
                .body(new BookResponse(book));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookRequest request) {
        Book updatedBook = bookService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedBook);
    }

    @GetMapping("/book/history/{id}")
    public ResponseEntity<List<BookLoanResponse>> findBookLoan(@PathVariable Long id) {
        List<BookLoanResponse> bookLoanResponses = bookService.findByBookIdIs(id)
                .stream()
                .map(BookLoanResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(bookLoanResponses);
    }
}
