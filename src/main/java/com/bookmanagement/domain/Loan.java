package com.bookmanagement.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Loan {

    @Id @GeneratedValue
    @Column(name = "loan_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    @Builder
    public Loan(User user, Book book, LocalDateTime loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public void updateReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
