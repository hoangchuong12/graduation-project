package com.thaihoangchuong.userservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserToServiceResponse {

    private String name;

    private String email;

    private String phone;

    private byte[] avarta;

    private String address;
}
