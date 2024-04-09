package com.thaihoangchuong.Brand.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.thaihoangchuong.Brand.payload.response.ErrorResponse;


@ControllerAdvice
public class ResResponseEntityException extends ResponseEntityExceptionHandler{
    @ExceptionHandler(BrandServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(BrandServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

}
