package com.mawulidev.userhttpclient.service;

import com.mawulidev.userhttpclient.dto.UserDto;
import com.mawulidev.userhttpclient.dto.UserResponse;
import com.mawulidev.userhttpclient.dto.Users;

public interface UserService {
//    Users findAll();

    UserResponse findOne(Integer id);

    //    Users search(String name);
    UserResponse delete(Integer id);

    Users findAllPaginated(int skip, int limit);

    Users search(String name);
    UserResponse createUser(UserDto userDto);
}
