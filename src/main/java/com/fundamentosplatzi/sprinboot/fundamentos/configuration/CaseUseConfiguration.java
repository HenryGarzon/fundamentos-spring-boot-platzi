package com.fundamentosplatzi.sprinboot.fundamentos.configuration;


import com.fundamentosplatzi.sprinboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.sprinboot.fundamentos.caseuse.GetUserImplement;
import com.fundamentosplatzi.sprinboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {



    @Bean
    GetUser getUser(UserService userService){

        return new GetUserImplement(userService);
    }

}
