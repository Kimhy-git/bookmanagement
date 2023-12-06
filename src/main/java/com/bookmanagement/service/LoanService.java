package com.bookmanagement.service;

import com.bookmanagement.domain.Book;
import com.bookmanagement.domain.Loan;
import com.bookmanagement.domain.User;
import com.bookmanagement.dto.LoanAddRequest;
import com.bookmanagement.repository.BookRepository;
import com.bookmanagement.repository.LoanRepository;
import com.bookmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public Loan save(LoanAddRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("not found user: "+request.getUserId()));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("not found book:"+request.getBookId()));
        return loanRepository.save(Loan.builder()
                        .user(user)
                        .book(book)
                        .loanDate(LocalDateTime.now())
                        .build());
    }

    public Loan returnById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        loan.updateReturnDate(LocalDateTime.now());
        return loan;
    }
}
