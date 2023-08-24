package com.travel.controllers;

import com.travel.DTO.UserDto;
import com.travel.Entitties.User;
import com.travel.repo.UserRepository;
import com.travel.service.UserServiice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserServiice userServiice;

    @GetMapping("/all")
    public List<UserDto> getall() {
        return userServiice.getlluser();
    }

    @GetMapping("/user")
    public UserDto getuser(@RequestParam("id") int id) {
        return userServiice.getById(id);
    }

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto userDto) {
        return userServiice.createuser(userDto);
    }

    @PutMapping("/update")
    public UserDto updateusers(@RequestParam("id") int id, @RequestBody UserDto userDto) {
        return userServiice.updateuser(id, userDto);
    }

    @DeleteMapping("/remove")
    public UserDto remove(@RequestParam("id") int id) {
        return userServiice.deleteuser(id);
    }


}