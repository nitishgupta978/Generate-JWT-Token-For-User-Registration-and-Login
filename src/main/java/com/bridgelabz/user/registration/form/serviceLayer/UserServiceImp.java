package com.bridgelabz.user.registration.form.serviceLayer;

import com.bridgelabz.user.registration.form.dto.UserLoginDTO;
import com.bridgelabz.user.registration.form.dto.UserRegistrationDTO;
import com.bridgelabz.user.registration.form.entity.UserData;
import com.bridgelabz.user.registration.form.repository.UserRegistrationRepository;
import com.bridgelabz.user.registration.form.token.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class : User Service Implementation Class.
 *  * @author : Nitish Gupta
 */
@Slf4j
@Service
public class UserServiceImp implements UserServiceLayer {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        UserData userData=null;
        userData=new UserData( userLoginDTO);
        String Token = tokenUtil.createToken(userData.getUserId());
        log.info("Login User Service Method Successfully executed");
        String message = "Logged in successfully.! your token is"+tokenUtil;
        return message;
    }


    @Override
    public UserData registerUser(UserRegistrationDTO userRegistrationDTO) {
        String encodedPassword =bCryptPasswordEncoder.encode(userRegistrationDTO.getPassword());
        userRegistrationDTO.setPassword(encodedPassword);
        UserData userData= null;
        userData=new UserData(userRegistrationDTO);
        userRegistrationRepository .save(userData);
        return userData;
    }

    @Override
    public List<UserData> getUserInfo() {
        log.info("getUserInfo Service Method Successfully executed");
        return userRegistrationRepository.findAll() ;
    }
}
