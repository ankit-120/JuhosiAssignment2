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
public class LoginController {

    @Autowired
    private UserService userService;

    //login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        UserDto user = this.userService.getUser(userDto.getId());
        if(user.getPassword().equals(userDto.getPassword())){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new ApiResponse("Wrong password",false),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updatePassword(@RequestBody UserDto userDto,@PathVariable int id){
        UserDto userDto1 = this.userService.updatePassword(userDto, id);
        return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

}
