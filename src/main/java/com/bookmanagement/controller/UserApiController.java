package com.bookmanagement.controller;

import com.bookmanagement.domain.User;
import com.bookmanagement.dto.UserCancelRequest;
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
    public ResponseEntity<User> joinUser(@RequestBody UserJoinRequest request) {
        User user = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Void> cancelUser(@RequestBody UserCancelRequest request) {
        userService.cancelById(request.getId());

        return ResponseEntity.ok()
                .build();
    }
}
