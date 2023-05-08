package com.example.ws_day2_ex2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authorities")
public class Authority {
  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "userid")
  private  User user;

  private String name;
}
