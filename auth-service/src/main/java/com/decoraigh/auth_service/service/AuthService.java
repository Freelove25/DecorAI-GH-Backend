package com.decoraigh.auth_service.service;

import com.decoraigh.auth_service.dto.*;
import com.decoraigh.auth_service.model.*;
import com.decoraigh.auth_service.repository.*;
import com.decoraigh.auth_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpTokenRepository otpTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already registered";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setLocation(request.getLocation());
        user.setRole(Role.valueOf(request.getRole().toUpperCase()));
        user.setVerified(false);
        userRepository.save(user);

        sendOtp(request.getEmail());
        return "Registration successful. Check your email for OTP.";
    }

    public void sendOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        OtpToken token = new OtpToken();
        token.setEmail(email);
        token.setOtp(otp);
        token.setExpiresAt(LocalDateTime.now().plusMinutes(10));
        token.setUsed(false);
        otpTokenRepository.save(token);
        System.out.println("OTP for " + email + ": " + otp);
    }

    public String verifyOtp(OtpVerificationRequest request) {
        Optional<OtpToken> token = otpTokenRepository
                .findByEmailAndOtpAndUsedFalse(request.getEmail(), request.getOtp());

        if (token.isEmpty()) return "Invalid or expired OTP";
        if (token.get().getExpiresAt().isBefore(LocalDateTime.now())) return "OTP expired";

        token.get().setUsed(true);
        otpTokenRepository.save(token.get());

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        user.ifPresent(u -> {
            u.setVerified(true);
            userRepository.save(u);
        });

        return "Account verified successfully";
    }

    public AuthResponse login(LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) return new AuthResponse(null, null, "User not found");
        if (!user.get().isVerified()) return new AuthResponse(null, null, "Account not verified");
        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            return new AuthResponse(null, null, "Invalid password");
        }

        String token = jwtUtil.generateToken(user.get().getEmail(), user.get().getRole().name());
        return new AuthResponse(token, user.get().getRole().name(), "Login successful");
    }
}
