package com.thaihoangchuong.bannerservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SliderServiceCustomException extends RuntimeException{
    private String errorCode;
    public SliderServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
