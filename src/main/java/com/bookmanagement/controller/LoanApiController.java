package com.bookmanagement.controller;

import com.bookmanagement.domain.Book;
import com.bookmanagement.domain.Loan;
import com.bookmanagement.dto.LoanAddRequest;
import com.bookmanagement.service.BookService;
import com.bookmanagement.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoanApiController {

    private final LoanService loanService;
    private final BookService bookService;

    @PostMapping("/loan")
    public ResponseEntity<Loan> addLoan(@RequestBody LoanAddRequest request) {
        Book book = bookService.findById(request.getBookId());
        if(book.isLoan_status()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .build();
        }

        Loan loan = loanService.save(request);
        bookService.updateStatusLoan(request.getBookId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(loan);
    }

    @PutMapping("/loan/{id}")
    public ResponseEntity<Void> returnLoan(@PathVariable Long id) {
        Loan loan = loanService.returnById(id);
        bookService.updateStatusReturn(loan.getBook().getId());

        return ResponseEntity.ok()
                .build();
    }
}
