package com.fundamentosplatzi.sprinboot.fundamentos.caseuse;

import com.fundamentosplatzi.sprinboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprinboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {

        return userService.getAllUsers();
    }

}
