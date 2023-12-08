package com.bookmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String password;
    private boolean status;

    @Builder
    public User(String email, String password, boolean status) {
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public void cancel() {
        this.status = false;
    }
}
