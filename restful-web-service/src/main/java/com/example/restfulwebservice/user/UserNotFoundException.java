package com.example.restfulwebservice.user;
// HTTP Status code
// 2XX -> OK
// 4XX -> Client
// 5XX -> Server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 404 Not Found
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
