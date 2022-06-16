package com.bridgelabz.user.registration.form.entity;

import com.bridgelabz.user.registration.form.dto.UserLoginDTO;
import com.bridgelabz.user.registration.form.dto.UserRegistrationDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User_Data")
@Data
public  class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")

    private long userId;
    private String firstName;
    private  String lastName;
    private String password;
    private String emailId;

    public UserData(UserRegistrationDTO userRegistrationDTO) {
        this.userId=userRegistrationDTO.userId;
        this.firstName = userRegistrationDTO.firstName;
        this.lastName = userRegistrationDTO.lastName;
        this.password =userRegistrationDTO.password;
        this.emailId = userRegistrationDTO.emailId;
    }

    public UserData() {
    }

    public UserData (UserLoginDTO userLoginDTO) {
        this.emailId=userLoginDTO.emailId;
        this.password =userLoginDTO.password;
    }
}
