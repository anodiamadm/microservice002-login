package com.anodiam.LoginRESTAPI.repository.Permission;

import com.anodiam.LoginRESTAPI.model.Permission;

public interface PermissionService {
    Permission findByPermissionName(String permissionName);
}
