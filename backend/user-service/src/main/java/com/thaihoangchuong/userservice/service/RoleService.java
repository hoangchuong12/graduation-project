package com.thaihoangchuong.userservice.service;

import java.util.List;
import java.util.UUID;

import com.thaihoangchuong.userservice.payload.request.RoleRequest;
import com.thaihoangchuong.userservice.payload.response.RoleResponse;



public interface RoleService {

    RoleResponse create(RoleRequest roleRequest);

    RoleResponse getById(UUID id);

    List<RoleResponse> getAll();
    
    RoleResponse update(UUID id, RoleRequest roleRequest);

    RoleResponse delete(UUID id);
}
