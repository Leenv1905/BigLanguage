package com.tst.biglanguage.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
//Dùng cho:
//admin tạo user
//sau này dùng cho register
@Getter
@Setter
public class UserCreateRequest {

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
