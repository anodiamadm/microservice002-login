package com.anodiam.LoginRESTAPI.serviceRepository.Permission;

import com.anodiam.LoginRESTAPI.model.Permission;

public interface PermissionService {
    Permission findByPermissionName(String permissionName);
}
