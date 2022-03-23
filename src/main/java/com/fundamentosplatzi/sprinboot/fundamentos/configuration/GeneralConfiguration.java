package com.fundamentosplatzi.sprinboot.fundamentos.configuration;

import com.fundamentosplatzi.sprinboot.fundamentos.bean.MyBeanWhitProperties;
import com.fundamentosplatzi.sprinboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.sprinboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name1;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    // Values para base de datos
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Bean
    public MyBeanWhitProperties function(){

        return new MyBeanWithPropertiesImplement(name1, apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder= DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    };



}
