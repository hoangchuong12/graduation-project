package com.thaihoangchuong.userservice.payload.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleRequest {

    private String name;

    private String description;

    private int role;
}
