package com.example.NewShop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.checkerframework.checker.index.qual.Positive;
//import javax.validation.constraints.Positive;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private long userId;
    private String orderDate;
    private String status;
//    @NotNull(message="Total amount cannot be null")
//    @Positive(message="Total amount must be positive")
    private Double totalAmount;
}
