package com.restaurant.restaurantbillingsystem.restImpl;

import com.restaurant.restaurantbillingsystem.constants.AllConstants;
import com.restaurant.restaurantbillingsystem.rest.UserRest;
import com.restaurant.restaurantbillingsystem.service.UserService;
import com.restaurant.restaurantbillingsystem.utils.RestaurantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
            return RestaurantUtils.getResponseEntity(AllConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
