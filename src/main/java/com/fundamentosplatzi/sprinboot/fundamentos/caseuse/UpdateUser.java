package com.fundamentosplatzi.sprinboot.fundamentos.caseuse;


import com.fundamentosplatzi.sprinboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprinboot.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }


    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
