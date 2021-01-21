package com.example.restfulwebservice;

// lombok
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldBean {

//    public HelloWorldBean(String message) {
//        this.message = message;
//    }
    private String message; // lombok -> setter, getter 포함되어있음
}
