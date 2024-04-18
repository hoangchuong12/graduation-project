package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryServiceCustomException extends RuntimeException{
    private String errorCode;
    public CategoryServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
