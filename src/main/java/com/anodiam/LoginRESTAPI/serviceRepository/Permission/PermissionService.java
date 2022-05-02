package com.anodiam.LoginRESTAPI.serviceRepository.Permission;

import com.anodiam.LoginRESTAPI.model.Permission;

import java.util.Optional;

public interface PermissionService {
    Optional<Permission> findByPermissionName(String permissionName);
}
