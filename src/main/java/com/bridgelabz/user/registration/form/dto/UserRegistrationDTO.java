package com.bridgelabz.user.registration.form.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public @ToString class UserRegistrationDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="firstname name Invalid" )
    public String  firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="lastname name Invalid" )
    public String  lastName;
    @NotBlank(message = "please enter the emailId")
    public String emailId;
    @NotBlank(message = "please enter the password")
    public String  password;
    public long userId;


    public UserRegistrationDTO(String firstName, String lastName, String password, String emailId,long userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailId = emailId;
        this.userId=userId;
    }



}
