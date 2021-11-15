package com.anodiam.LoginRESTAPI.repository.Permission;

import com.anodiam.LoginRESTAPI.model.Permission;

abstract class PermissionServiceImpl implements PermissionService {

    @Override
    public Permission findByPermissionName(String permissionName) {
        return new PermissionServiceDal().findByPermissionName(permissionName);
    }
}
