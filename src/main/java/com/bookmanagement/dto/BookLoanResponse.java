package com.bookmanagement.dto;

import com.bookmanagement.domain.Book;
import com.bookmanagement.domain.Loan;
import com.bookmanagement.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookLoanResponse {
    private User user;
    private Book book;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    public BookLoanResponse(Loan loan) {
        this.user = loan.getUser();
        this.book = loan.getBook();
        this.loanDate = loan.getLoanDate();
        this.returnDate = loan.getReturnDate();
    }
}
