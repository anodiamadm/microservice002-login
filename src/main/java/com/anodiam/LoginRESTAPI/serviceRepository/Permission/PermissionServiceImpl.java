package com.anodiam.LoginRESTAPI.serviceRepository.Permission;

import com.anodiam.LoginRESTAPI.model.Permission;

import java.util.Optional;

abstract class PermissionServiceImpl implements PermissionService {

    @Override
    public Optional<Permission> findByPermissionName(String permissionName) {
        return new PermissionServiceDal().findByPermissionName(permissionName);
    }
}
