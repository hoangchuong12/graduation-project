package com.thaihoangchuong.userservice.payload.request;



import com.thaihoangchuong.userservice.entity.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NotificationRequest {

    private User user;

    private String description;

    private String detail;

    private int statusOfSee;

    private String linkTo;

}
