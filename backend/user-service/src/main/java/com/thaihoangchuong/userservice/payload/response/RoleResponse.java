package com.thaihoangchuong.userservice.payload.response;

import java.util.UUID;

import lombok.Data;

@Data
public class RoleResponse {

    private UUID id;

    private String name;

    private String description;

    private int role;
}
