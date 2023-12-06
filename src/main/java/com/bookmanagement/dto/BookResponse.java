package com.bookmanagement.dto;

import com.bookmanagement.domain.Book;
import com.bookmanagement.domain.Loan;
import lombok.Getter;

import java.util.List;

@Getter
public class BookResponse {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private boolean loan_status;
    private List<Loan> loan_list;

    public BookResponse(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
        this.loan_status = book.isLoan_status();
        this.loan_list = book.getLoan_list();
    }
}
