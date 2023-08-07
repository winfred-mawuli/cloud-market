package com.mawulidev.userhttpclient.service;

import com.mawulidev.userhttpclient.config.UserHttpService;
import com.mawulidev.userhttpclient.dto.UserDto;
import com.mawulidev.userhttpclient.dto.UserResponse;
import com.mawulidev.userhttpclient.dto.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserHttpService userHttpService;


    @Override
    public Users findAllPaginated(int skip, int limit) {
        return userHttpService.findAll(skip, limit);
    }


    @Override
    public UserResponse findOne(Integer id) {
        return userHttpService.findOne(id);
    }


    @Override
    public Users search(String name) {
        return userHttpService.search(name);
    }

    @Override
    public UserResponse delete(Integer id) {
        UserResponse user = userHttpService.delete(id);
        user.setDeleted(true);
        return user;
    }

    @Override
    public UserResponse createUser(UserDto userDto) {
        return userHttpService.createUser(userDto);
    }


}
