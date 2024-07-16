package com.example.NewShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_Id", nullable = false)
    private long userId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}
