package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class GreetingsController {
    @GetMapping("/hai")
    public ResponseEntity<String> sayhello(){
        return ResponseEntity.ok("hello user");
    }
    @GetMapping("/bye")
    public ResponseEntity<String> sayhbye(){
        return ResponseEntity.ok("bye user");
    }
}
