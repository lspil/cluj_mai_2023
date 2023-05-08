package com.example.ws_day2_ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.oauth2ResourceServer(c ->
        c.opaqueToken()
            .introspectionClientCredentials("client","secret")
            .introspectionUri("http://localhost:8080/oauth2/introspect"));

    http.authorizeHttpRequests().anyRequest().authenticated();

    return http.build();
  }
}
