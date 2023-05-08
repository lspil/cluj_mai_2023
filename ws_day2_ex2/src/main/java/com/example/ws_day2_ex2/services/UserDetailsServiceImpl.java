package com.example.ws_day2_ex2.services;

import com.example.ws_day2_ex2.entities.User;
import com.example.ws_day2_ex2.repositories.UserDetailsRepository;
import com.example.ws_day2_ex2.utils.SecurityUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserDetailsRepository userDetailsRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userDetailsRepository.findByUsername(username).map(SecurityUserDetails::new)
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found"));
  }

  @Transactional
  public void addUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userDetailsRepository.save(user);
  }
}
