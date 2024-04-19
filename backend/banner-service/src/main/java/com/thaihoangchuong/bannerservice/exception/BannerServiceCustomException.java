package com.thaihoangchuong.bannerservice.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BannerServiceCustomException extends RuntimeException{
    private String errorCode;
    public BannerServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
