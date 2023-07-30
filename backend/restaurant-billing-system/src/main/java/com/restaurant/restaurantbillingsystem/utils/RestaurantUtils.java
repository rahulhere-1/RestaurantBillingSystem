package com.restaurant.restaurantbillingsystem.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestaurantUtils {

    private RestaurantUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\"" + message+"\" }",httpStatus);
    }
}
