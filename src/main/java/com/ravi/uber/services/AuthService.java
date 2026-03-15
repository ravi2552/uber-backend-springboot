package com.ravi.uber.services;


import com.ravi.uber.dto.DriverDto;
import com.ravi.uber.dto.SignupDto;
import com.ravi.uber.dto.UserDto;

public interface AuthService {
    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);
}
