package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OptionValueServiceCustomException extends RuntimeException{
    private String errorCode;
    public OptionValueServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
