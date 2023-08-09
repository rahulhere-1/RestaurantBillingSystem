package com.restaurant.restaurantbillingsystem.JWT;

import com.restaurant.restaurantbillingsystem.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    private com.restaurant.restaurantbillingsystem.POJO.User userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetails = userDao.findByEmail(username);
        if(!Objects.isNull(userDetails))
            return new User(userDetails.getEmail(), userDetails.getPassword(),new ArrayList<>());
        else throw new UsernameNotFoundException("User not found");
    }



}
