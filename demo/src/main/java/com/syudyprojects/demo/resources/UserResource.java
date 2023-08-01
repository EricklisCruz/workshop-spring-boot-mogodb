package com.syudyprojects.demo.resources;

import com.syudyprojects.demo.domain.entities.User;
import com.syudyprojects.demo.dto.UserDTO;
import com.syudyprojects.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findByUserId(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = uriComponentsBuilder.path("{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
