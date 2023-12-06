package com.bookmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanAddRequest {
    private Long userId;
    private Long bookId;
}
