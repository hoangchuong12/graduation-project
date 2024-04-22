package com.thaihoangchuong.userservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.thaihoangchuong.userservice.payload.request.RoleRequest;
import com.thaihoangchuong.userservice.payload.response.RoleResponse;
import com.thaihoangchuong.userservice.service.RoleService;

@RestController
@RequestMapping("user-services/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest roleRequest) {
        RoleResponse createdRole = roleService.create(roleRequest);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable UUID id) {
        RoleResponse role = roleService.getById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        List<RoleResponse> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoleResponse> updateRole(@RequestBody RoleRequest roleRequest, @PathVariable UUID id) {
        RoleResponse updatedRole = roleService.update(id, roleRequest);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoleResponse> deleteRole(@PathVariable UUID id) {
        RoleResponse deletedRole = roleService.delete(id);
        return ResponseEntity.ok(deletedRole);
    }
}
