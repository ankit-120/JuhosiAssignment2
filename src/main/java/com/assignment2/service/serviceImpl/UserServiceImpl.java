package com.assignment2.service.serviceImpl;

import com.assignment2.dto.UserDto;
import com.assignment2.entity.User;
import com.assignment2.exception.ResourceNotFoundException;
import com.assignment2.repo.UserRepo;
import com.assignment2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto getUser(int id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto updatePassword(UserDto userDto, int id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        user.setPassword(userDto.getPassword());
        User save = this.userRepo.save(user);
        return this.modelMapper.map(save, UserDto.class);
    }

    @Override
    public UserDto findByPhoneNumber(String mobile) {
        User user = this.userRepo.findByPhoneNumber(mobile);
        if(user != null){
            return this.modelMapper.map(user,UserDto.class);
        }
        return null;
    }
}
