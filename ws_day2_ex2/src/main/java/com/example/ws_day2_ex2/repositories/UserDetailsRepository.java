package com.example.ws_day2_ex2.repositories;

import com.example.ws_day2_ex2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, Long> {

  @Query("select u from User u where u.name=:username")
  Optional<User> findByUsername(String username);
}
