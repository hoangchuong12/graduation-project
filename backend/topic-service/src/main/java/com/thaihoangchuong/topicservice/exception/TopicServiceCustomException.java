package com.thaihoangchuong.topicservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TopicServiceCustomException extends RuntimeException{

    private String errorCode;
    public TopicServiceCustomException (String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}