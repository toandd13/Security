package com.example.shopappbe.dtos;

import com.example.shopappbe.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {

    @NotBlank(message = "email khong duoc de trong")
    @Email(message = "email phai dung dinh dang")
    private String email;

    @NotBlank(message = "full name khong duoc de trong")
    private String fullName;

    @NotBlank(message = "password khong duoc de trong")
    private String password;


    private Role role;
}
