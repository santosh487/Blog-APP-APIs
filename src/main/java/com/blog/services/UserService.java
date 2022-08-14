package com.blog.services;

import com.blog.entities.User;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Integer userId);

    UserDto getUser(Integer userId);

    List<UserDto> getAllUser ();

    void deleteUser(Integer userId);
}
