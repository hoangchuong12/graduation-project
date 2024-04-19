package com.thaihoangchuong.bannerservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.thaihoangchuong.bannerservice.payload.response.ErrorResponse;

@ControllerAdvice
public class RestresponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(BannerServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleBannerServiceException(BannerServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(InformationServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleInformationServiceException(InformationServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(SliderServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleSlidertionServiceException(SliderServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
}
