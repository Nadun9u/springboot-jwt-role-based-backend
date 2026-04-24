package com.springbootacademy.security_jwt.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StanderedRespnseDTO {

    private int code;
    private String message;
    private Object data;
}
