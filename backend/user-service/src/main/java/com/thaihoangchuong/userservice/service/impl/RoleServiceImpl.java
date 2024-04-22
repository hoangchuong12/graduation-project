package com.thaihoangchuong.userservice.service.impl;

import org.springframework.stereotype.Service;

import com.thaihoangchuong.userservice.entity.Role;
import com.thaihoangchuong.userservice.exception.CustomException;
import com.thaihoangchuong.userservice.payload.request.RoleRequest;
import com.thaihoangchuong.userservice.payload.response.RoleResponse;
import com.thaihoangchuong.userservice.repository.RoleRepository;
import com.thaihoangchuong.userservice.service.RoleService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponse create(RoleRequest roleRequest) {
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        role.setRole(roleRequest.getRole());

        Role savedRole = roleRepository.save(role);
        return convertToResponse(savedRole);
    }

    @Override
    public RoleResponse getById(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new CustomException("Role not found", "ROLE_NOT_FOUND"));
        return convertToResponse(role);
    }

    @Override
    public List<RoleResponse> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse update(UUID id, RoleRequest roleRequest) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new CustomException("Role not found", "ROLE_NOT_FOUND"));

        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        role.setRole(roleRequest.getRole());

        Role updatedRole = roleRepository.save(role);
        return convertToResponse(updatedRole);
    }

    @Override
    public RoleResponse delete(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new CustomException("Role not found", "ROLE_NOT_FOUND"));
        roleRepository.delete(role);
        return convertToResponse(role);
    }

    private RoleResponse convertToResponse(Role role) {
        RoleResponse response = new RoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        response.setDescription(role.getDescription());
        response.setRole(role.getRole());
        return response;
    }
}
