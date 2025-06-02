package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.User;
import com.example.nono.s_online_clinic.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        // Save user with plain text password
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean authenticate(String username, String password) {
        User user = findByUsername(username);
        // Plain text password comparison
        return user != null && user.getPassword().equals(password);
    }
}
