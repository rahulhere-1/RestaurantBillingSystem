package com.restaurant.restaurantbillingsystem.serviceImpl;

import com.restaurant.restaurantbillingsystem.POJO.User;
import com.restaurant.restaurantbillingsystem.constants.AllConstants;
import com.restaurant.restaurantbillingsystem.dao.UserDao;
import com.restaurant.restaurantbillingsystem.service.UserService;
import com.restaurant.restaurantbillingsystem.utils.RestaurantUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside SignUp : {}", requestMap);
        try {
            if (validateSignUp(requestMap)) {
                User user = userDao.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return RestaurantUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
                } else return RestaurantUtils.getResponseEntity("email already exists", HttpStatus.BAD_REQUEST);
            } else
                return RestaurantUtils.getResponseEntity(AllConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return RestaurantUtils.getResponseEntity("Caught up in exception", HttpStatus.BAD_REQUEST);
         }
    }

    private boolean validateSignUp(Map<String, String> requestMap){
        if(requestMap.containsKey("name") && requestMap.containsKey("email") &&
                requestMap.containsKey("contactNumber") && requestMap.containsKey("password") )
            return true;
        else return false;
    }
    private User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setRole(requestMap.get("role"));
        user.setStatus(requestMap.get("status"));

        return user;
    }
}
