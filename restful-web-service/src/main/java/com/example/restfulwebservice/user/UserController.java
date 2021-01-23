package com.example.restfulwebservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // id는 문자형태로 전달됨, 그냥 int라고 선언하면 int로 자동으로 바뀜
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() // 사용자 요청 uri
                .path("/{id}") // buildAndExpand를 통해 얻은 값 들어옴
                .buildAndExpand(savedUser.getId()) // {id}
                .toUri(); // uri 생성

        return ResponseEntity.created(location).build();
        // created(URI) : Create a new builder with a CREATED status and a location header set to the given URI.
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);
        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        User returnUser = service.updateById(id, user);
        if(returnUser == null) {
            throw new UserNotFoundException(String.format("ID[%S] not found", id));
        }
    }


}
