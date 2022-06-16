package com.bridgelabz.user.registration.form.serviceLayer;

import com.bridgelabz.user.registration.form.dto.UserLoginDTO;
import com.bridgelabz.user.registration.form.dto.UserRegistrationDTO;
import com.bridgelabz.user.registration.form.entity.UserData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceLayer {
    String loginUser(UserLoginDTO userLoginDTO);

    UserData registerUser(UserRegistrationDTO userRegistrationDTO);

    List<UserData> getUserInfo();
}
