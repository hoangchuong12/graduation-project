package com.project.commodity.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductOptionServiceCustomException extends  RuntimeException{
    private String errorCode;
    public ProductOptionServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
