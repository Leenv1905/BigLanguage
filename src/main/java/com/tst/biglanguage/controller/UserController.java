package com.tst.biglanguage.controller;

import com.tst.biglanguage.dto.user.UserCreateRequest;
import com.tst.biglanguage.dto.user.UserUpdateRequest;
import com.tst.biglanguage.dto.user.UserResponse;
import com.tst.biglanguage.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize đặt ở Controller
//Đây là best practice. Không nên đặt ở Service bị phụ thuộc Security

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ================= CREATE =================
    // Tạo user mới – thường dùng cho admin tạo account
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserCreateRequest request
    ) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    // ================= READ =================
    // ADMIN xem toàn bộ user
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ADMIN xem user theo id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // ================= UPDATE =================
    // Chỉ ADMIN được sửa user
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request
    ) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    // ================= DELETE =================
    // Chỉ ADMIN được xóa user
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
