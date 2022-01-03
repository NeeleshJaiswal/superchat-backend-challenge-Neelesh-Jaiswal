package com.superchat.services;

import com.superchat.model.User;
import com.superchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(Long userId) {
        return userRepository.getById(userId);
    }
}