package com.thaihoangchuong.bannerservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InformationServiceCustomException extends RuntimeException{
    private String errorCode;
    public InformationServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
