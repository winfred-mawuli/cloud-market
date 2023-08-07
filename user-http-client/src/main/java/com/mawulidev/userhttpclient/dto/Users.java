package com.mawulidev.userhttpclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private List<UserResponse> users;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
