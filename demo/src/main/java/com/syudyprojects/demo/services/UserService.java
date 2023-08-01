package com.syudyprojects.demo.services;

import com.syudyprojects.demo.domain.entities.User;
import com.syudyprojects.demo.dto.UserDTO;
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

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        Boolean find = userRepository.existsById(id);
        if (find) {
            userRepository.deleteById(id);
        }
        throw new ObjectNotFoundException("User not found!");

    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail());
    }
}
