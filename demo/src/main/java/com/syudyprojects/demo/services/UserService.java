package com.syudyprojects.demo.services;

import com.syudyprojects.demo.domain.entities.User;
import com.syudyprojects.demo.repositories.UserRepository;
import com.syudyprojects.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).
                orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }
}
