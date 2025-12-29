package com.tst.biglanguage.mapper;

import com.tst.biglanguage.dto.user.UserResponse;
import com.tst.biglanguage.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .enabled(user.isEnabled())
                .roles(
                        user.getRoles()
                                .stream()
                                .map(role -> role.getName())
                                .collect(Collectors.toSet())
                )
                .build();
    }
}
