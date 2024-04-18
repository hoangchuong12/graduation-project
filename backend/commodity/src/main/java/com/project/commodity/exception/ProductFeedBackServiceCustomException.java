package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductFeedBackServiceCustomException extends  RuntimeException{
    private String errorCode;
    public ProductFeedBackServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
