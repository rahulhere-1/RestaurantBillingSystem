package com.restaurant.restaurantbillingsystem.dao;

import com.restaurant.restaurantbillingsystem.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
