package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductServiceCustomExcePtion extends RuntimeException{
    private String errorCode;
    public ProductServiceCustomExcePtion (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
