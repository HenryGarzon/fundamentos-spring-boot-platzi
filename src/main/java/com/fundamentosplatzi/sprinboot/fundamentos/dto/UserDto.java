package com.fundamentosplatzi.sprinboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {

    private Long id;
    private String name;
    private LocalDate birdDate;

    public UserDto(Long id, String name, LocalDate birdDate) {
        this.id = id;
        this.name = name;
        this.birdDate = birdDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birdDate='" + birdDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirdDate() {
        return birdDate;
    }

    public void setBirdDate(LocalDate birdDate) {
        this.birdDate = birdDate;
    }
}
