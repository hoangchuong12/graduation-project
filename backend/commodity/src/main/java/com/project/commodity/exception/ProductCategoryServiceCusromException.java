package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductCategoryServiceCusromException extends  RuntimeException{
    private String errorCode;
    public ProductCategoryServiceCusromException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
