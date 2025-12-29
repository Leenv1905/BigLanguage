package com.tst.biglanguage.dto.user;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
//Dùng cho: dlieeujt rả về frontend
//admin view user
//user xem profile
@Getter
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private boolean enabled;

    private Set<String> roles;
}
