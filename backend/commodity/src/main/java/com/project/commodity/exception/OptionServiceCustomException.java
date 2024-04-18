package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OptionServiceCustomException extends RuntimeException{
    private String errorCode;
    public OptionServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
