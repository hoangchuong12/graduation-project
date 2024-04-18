package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductSaleServiceCustomException extends  RuntimeException {
    private String errorCode;
    public ProductSaleServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
