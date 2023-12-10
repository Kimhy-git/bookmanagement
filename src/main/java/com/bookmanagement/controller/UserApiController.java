package com.bookmanagement.controller;

import com.bookmanagement.domain.User;
import com.bookmanagement.dto.UserJoinRequest;
import com.bookmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Void> joinUser(@RequestBody UserJoinRequest request) {
        userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> cancelUser(@PathVariable long id) {
        userService.cancelById(id);

        return ResponseEntity.ok()
                .build();
    }
}
