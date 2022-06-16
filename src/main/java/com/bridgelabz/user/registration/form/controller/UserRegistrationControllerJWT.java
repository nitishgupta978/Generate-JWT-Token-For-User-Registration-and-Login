package com.bridgelabz.user.registration.form.controller;

import com.bridgelabz.user.registration.form.dto.ResponseDTO;
import com.bridgelabz.user.registration.form.dto.UserLoginDTO;
import com.bridgelabz.user.registration.form.dto.UserRegistrationDTO;
import com.bridgelabz.user.registration.form.entity.UserData;
import com.bridgelabz.user.registration.form.serviceLayer.UserServiceLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/registration")
public class UserRegistrationControllerJWT {

    @Autowired
     private UserServiceLayer userServiceLayer;

    /**
     * Method :- Method for User Login.
     *
     * @param :- passing UserRegistrationDTO as Input
     * @return :- Returning Token.
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("inside userLogin Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Logged In Successfully!!!",
                userServiceLayer.loginUser(userLoginDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    /**
     * Method :- Method for User Registration.
     *
     * @param userDTO :- passing UserRegistrationDTO as Input
     * @return :- Returning UserData
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        UserData userData = null;
        log.info("inside registerUser Controller Method");
        userData = userServiceLayer.registerUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully.", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);

    }

    /**
     * Method :- Method to Get All User Records.
     *
     * @return :- Returning  All User Records Present in Database.
     */
    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<UserData> userDataList = null;
        userDataList = userServiceLayer.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}