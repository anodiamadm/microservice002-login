package com.anodiam.LoginRESTAPI.serviceRepository.Permission;

import com.anodiam.LoginRESTAPI.model.Permission;

abstract class PermissionServiceImpl implements PermissionService {

    @Override
    public Permission findByPermissionName(String permissionName) {
        return new PermissionServiceDal().findByPermissionName(permissionName);
    }
}
