package com.bookmanagement.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private boolean loan_status;

    @OneToMany(mappedBy = "book")
    private List<Loan> loan_list;

    @Builder
    public Book(String title, String author, String publisher, String isbn, boolean loan_status) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.loan_status = loan_status;
    }

    public void update(String title, String author, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public void updateStatus(boolean loan_status) {
        this.loan_status = loan_status;
    }
}
