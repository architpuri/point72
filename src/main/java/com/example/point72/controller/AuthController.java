package com.example.point72.controller;

import com.example.point72.dto.LoginRequest;
import com.example.point72.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/login")
  public String login(@RequestBody LoginRequest request) {
    if ("admin".equals(request.username()) && "password".equals(request.password())) {
      return jwtUtil.generateToken(request.username());
    }
    throw new RuntimeException("Authentication Failed: Invalid username or password");
  }
}
