package com.fundamentosplatzi.sprinboot.fundamentos.caseuse;


import com.fundamentosplatzi.sprinboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprinboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }


    public Object save(User newUser) {
        return userService.save(newUser);
    }
}
