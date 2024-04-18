package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TagServiceCustomException extends RuntimeException{
    private String errorCode;
    public TagServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
