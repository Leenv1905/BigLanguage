package com.tst.biglanguage.service;

import com.tst.biglanguage.dto.auth.AuthResponse;
import com.tst.biglanguage.dto.auth.LoginRequest;
import com.tst.biglanguage.dto.auth.RegisterRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    void register(RegisterRequest request);
}
