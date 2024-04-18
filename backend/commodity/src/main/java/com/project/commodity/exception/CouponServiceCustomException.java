package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CouponServiceCustomException extends RuntimeException{

    private String errorCode;
    public CouponServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
