package com.assignment2.repo;

import com.assignment2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByPhoneNumber(String mobile);

}
