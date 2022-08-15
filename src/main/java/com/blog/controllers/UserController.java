package com.blog.controllers;

import com.blog.entities.User;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    //POST - Created user

    @PostMapping
    public ResponseEntity<UserDto> createdUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }


    //PUT - Updated user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updatedUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
       UserDto updatedUser = this.userService.updateUser(userDto,userId);
       return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //DELETE - Deleted user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);

    }
    //GET - user get
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

}
