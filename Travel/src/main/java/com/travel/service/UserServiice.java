package com.travel.service;

import com.travel.DTO.UserDto;
import com.travel.Entitties.User;
import com.travel.exception.*;
import com.travel.exception.ObjectNoVAlidException;
import com.travel.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiice {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> getlluser() {
        List<User> users = userRepository.findAllusers();
        if (users.isEmpty()) {
            throw new NoUsersFoundException();
        } else {
            return users.stream().map(this::convert).collect(Collectors.toList());
        }
    }

    public UserDto getById(int id) {
        User user = userRepository.findbyUserId(id);
        if (user == null) {
            throw new UserNotFound(id);
        } else {
            return convert(user);
        }

    }

    public UserDto createuser(UserDto userDto) {
        if (userDto == null) {
            throw new ObjectNoVAlidException();
        } else {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setFirstname(userDto.getFirstName());
            user.setLastname(userDto.getLastName());
            user.setGender(userDto.getGender());
            user.setMobile(userDto.getMobile());
            userRepository.save(user);
            return convert(user);
        }
    }

    public UserDto updateuser(int id, UserDto userDto) {
        if (userDto == null) {
            throw new ObjectNoVAlidException();
        } else {
            User user = userRepository.findbyUserId(id);
            user.setMobile(userDto.getMobile());
            user.setFirstname(userDto.getFirstName());
            user.setEmail(userDto.getEmail());
            userRepository.save(user);
            return convert(user);
        }
    }

    public UserDto deleteuser(int Id) {
        User user = userRepository.findbyUserId(Id);
        if (user == null) {
            throw new NoUsersFoundException();
        } else {
            userRepository.delete(user);
            return convert(user);
        }

    }


    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstname());
        userDto.setLastName(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        userDto.setMobile(user.getMobile());
        return userDto;
    }

}
