package com.bridgelabz.user.registration.form.dto;

import com.bridgelabz.user.registration.form.entity.UserData;
import lombok.Data;

import java.util.List;

public  @Data class ResponseDTO {

    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
