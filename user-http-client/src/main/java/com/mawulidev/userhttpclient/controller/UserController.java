package com.mawulidev.userhttpclient.controller;

import com.mawulidev.userhttpclient.dto.UserDto;
import com.mawulidev.userhttpclient.dto.UserResponse;
import com.mawulidev.userhttpclient.dto.Users;
import com.mawulidev.userhttpclient.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
        @GetMapping("/v1/users")
        public Users getAll(@RequestParam(value = "skip", defaultValue = "0") int skip,
        @RequestParam(value = "limit", defaultValue = "10") int limit) {
            return userService.findAllPaginated(skip, limit);
    }

    @GetMapping(value = "v1/users/{id}")
    public UserResponse getUser(@PathVariable("id") Integer id) {
        return userService.findOne(id);
    }
    @GetMapping("/v1/users/search")
    public Users search(@RequestParam("q") String name){
            return userService.search(name);
    }

    @PostMapping("v1/users")
    public UserResponse createUser(@RequestBody UserDto user){
            return userService.createUser(user);
    }


    @DeleteMapping("/v1/users/{id}")
    public UserResponse delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

}
