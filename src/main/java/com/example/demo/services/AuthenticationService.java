package com.example.demo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.JwtAuthenticationResponse;
import com.example.demo.DTO.SignInRequest;
import com.example.demo.DTO.SignUpRequest;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UserRepository userRepository;
        private final UserServiceImp userService;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public JwtAuthenticationResponse signup(SignUpRequest request, Role role) {
                var user = User
                                .builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(role)
                                .build();

                user = userService.save(user);
                var jwt = jwtService.generateToken(user);
                return JwtAuthenticationResponse.builder()
                                .token(jwt)
                                .name(user.getName())
                                .role(user.getRole().name())
                                .email(user.getEmail())
                                .build();
        }

        public JwtAuthenticationResponse signin(SignInRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
                var jwt = jwtService.generateToken(user);
                return JwtAuthenticationResponse.builder()
                                .token(jwt)
                                .name(user.getName())
                                .role(user.getRole().name())
                                .email(user.getEmail())
                                .build();
        }

}
