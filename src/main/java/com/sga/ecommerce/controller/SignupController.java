package com.sga.ecommerce.controller;

import com.sga.ecommerce.dto.SignupDTO;
import com.sga.ecommerce.dto.UserDTO;
import com.sga.ecommerce.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO){
        if(userService.hasUserWithEmail(signupDTO.getEmail())){
            return new ResponseEntity<>("El usuario ya existe.", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDTO createdUser = userService.createUser(signupDTO);
        if(createdUser == null){
            return new ResponseEntity<>("Usuario no creado. Intentelo otra vez.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
