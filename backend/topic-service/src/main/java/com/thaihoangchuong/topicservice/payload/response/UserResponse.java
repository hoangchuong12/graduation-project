package com.thaihoangchuong.topicservice.payload.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {

    private String name;

    private String email;

    private String phone;

    private byte[] avarta;

    private String address;
}
