package com.bookmanagement.service;

import com.bookmanagement.domain.User;
import com.bookmanagement.dto.UserJoinRequest;
import com.bookmanagement.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserJoinRequest dto) {
        return userRepository.save(User.builder()
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .status(true)
                        .build());
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    @Transactional
    public void cancelById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+userId));

        user.cancel();
    }
}
