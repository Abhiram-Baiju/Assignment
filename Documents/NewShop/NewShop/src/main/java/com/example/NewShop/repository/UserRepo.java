package com.example.NewShop.repository;

import com.example.NewShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Long>{
}
