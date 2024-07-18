package com.example.NewShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
//new

    @NotNull(message = "name cannot be null")
    @Size(max = 25,message = "exceeded 25 characters")
    @NotEmpty(message = "name cannot be empty")
    private String name;

//    public void setName(Object name) {
//        if (name instanceof String) {
//            this.name = (String) name;
//        } else {
//            throw new IllegalArgumentException("Name must be a String");
//        }
//    }

    private String email;
    private String password;
    private String address;

    @NotNull(message = "name cannot be null")
    @Digits(integer = 10,fraction = 2,message = "it must be a digit")
    private String phoneNumber;
}
