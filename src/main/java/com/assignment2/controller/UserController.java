package com.assignment2.controller;

import com.assignment2.dto.UserDto;
import com.assignment2.service.UserService;
import com.assignment2.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("assignment2/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{mobile}")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String mobile){
        UserDto byPhoneNumber = this.userService.findByPhoneNumber(mobile);
        if(byPhoneNumber!=null){
            return new ResponseEntity<>(byPhoneNumber, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("Not Found",false),HttpStatus.NOT_FOUND);
    }

}
