package com.tst.biglanguage.dto.user;

import lombok.Getter;
import lombok.Setter;

//Dùng cho:
//ADMIN update user
//sau này mở rộng role / status

@Getter
@Setter
public class UserUpdateRequest {

    private String username;
    private String email;
    private String password;
    private Boolean enabled;
}
