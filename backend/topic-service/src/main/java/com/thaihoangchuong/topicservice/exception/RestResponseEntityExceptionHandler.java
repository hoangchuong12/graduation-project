package com.thaihoangchuong.topicservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.thaihoangchuong.topicservice.payload.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(TopicServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleTopicServiceException(TopicServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
}
