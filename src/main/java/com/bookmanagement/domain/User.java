package com.bookmanagement.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
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
