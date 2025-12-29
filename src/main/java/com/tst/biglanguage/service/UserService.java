package com.tst.biglanguage.service;

import com.tst.biglanguage.dto.user.UserCreateRequest;
import com.tst.biglanguage.dto.user.UserUpdateRequest;
import com.tst.biglanguage.dto.user.UserResponse;

// Ử DỤNG DTO, CHỈ LÀM VIỆC VỚI DTO, KO LÀM VC VỚI ENTITY
import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserUpdateRequest request);

    void deleteUser(Long id);
}
