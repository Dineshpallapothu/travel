package com.example.controller;


import com.example.config.JwtUtil;
import com.example.dao.UserDao;
import com.example.dto.AuthenticationRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  //  @Autowired
     private final AuthenticationManager authenticationManager;
  //  Authern authern;
     private final   UserDao userDao;
     private final JwtUtil jwtUtil;
     @PostMapping("/authenticate")
     public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
         final UserDetails userDetails=userDao.findUserByEmail(request.getEmail());
         if(userDetails!=null){
             return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
         }
         return ResponseEntity.status(400).body("some error has occured");
     }

}
