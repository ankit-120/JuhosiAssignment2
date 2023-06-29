package com.assignment2.service;

import com.assignment2.dto.UserDto;

public interface UserService {

    //get user
    UserDto getUser(int id);

    //update password
    UserDto updatePassword(UserDto userDto,int id);

    //get by phone number
    UserDto findByPhoneNumber(String mobile);

}
