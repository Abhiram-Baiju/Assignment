package com.example.NewShop.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.checkerframework.checker.index.qual.Positive;
//import javax.validation.constraints.Positive;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @NotNull(message ="uSerId cannot be empty")
    @Min(value = 1, message = "userId must be greater than 0")
    @Positive(message = "total amount must be a valid Id")
    private long userId;

    //@NotNull(message ="orderDate cannot be empty")
    @NotEmpty(message = "order ID cannot be empty")
    private String orderDate;

//    @NotNull(message ="status cannot be empty")
    @NotEmpty(message ="status cannot be empty")

    private String status;

    @NotNull(message="totalAmount cannot be null")
    @Positive(message = "total amount must be a positive number")
    @Digits(integer = 10,fraction = 2,message = "it must be a digit")
    private BigDecimal totalAmount;
}


/// OG
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long orderId;
//    private long userId;
//    private String orderDate;
//    private String status;
////    @NotNull(message="Total amount cannot be null")
////    @Positive(message="Total amount must be positive")
//    private Double totalAmount;
//}