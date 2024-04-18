package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BrandServiceCustomException extends RuntimeException{
    private String errorCode;
    public BrandServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
