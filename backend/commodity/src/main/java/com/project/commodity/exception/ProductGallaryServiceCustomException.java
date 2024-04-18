package com.project.commodity.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductGallaryServiceCustomException extends  RuntimeException{
    private String errorCode;
    public ProductGallaryServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
