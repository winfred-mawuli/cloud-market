package com.mawulidev.userhttpclient.config;

import com.mawulidev.userhttpclient.dto.UserDto;
import com.mawulidev.userhttpclient.dto.UserResponse;
import com.mawulidev.userhttpclient.dto.Users;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;


public interface UserHttpService {
    @GetExchange("/users")
    Users findAll(@RequestParam("skip") int skip, @RequestParam("limit") int limit);

    @GetExchange("/users/{id}")
    UserResponse findOne(@PathVariable("id") Integer id);

    @GetExchange("/users/search")
    Users search(@RequestParam("q") String name);

    @DeleteExchange("/users/{id}")
    UserResponse delete(@PathVariable("id") Integer id);
    @PostExchange("/users/add")
    UserResponse createUser(@RequestBody UserDto userDto);
}
