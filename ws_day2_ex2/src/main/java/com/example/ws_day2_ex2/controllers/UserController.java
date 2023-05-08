package com.example.ws_day2_ex2.controllers;

import com.example.ws_day2_ex2.entities.User;
import com.example.ws_day2_ex2.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserDetailsServiceImpl userDetailsService;

  @GetMapping("/demo")
  public String demo() {
    return "DEMO";
  }

  @PostMapping("/user")
  public void addUser(@RequestBody User user) {
    userDetailsService.addUser(user);
  }

  @GetMapping("/getUser")
  @PreAuthorize("hasAuthority('admin')")
  public Authentication getUser() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
