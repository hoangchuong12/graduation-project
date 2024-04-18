package com.project.commodity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductTagServiceCustomException extends RuntimeException {
    private String errorCode;
    public ProductTagServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
