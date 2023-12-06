package com.bookmanagement.repository;

import com.bookmanagement.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
