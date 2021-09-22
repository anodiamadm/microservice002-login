package com.anodiam.LoginRESTAPI.serviceRepository.Role;

import com.anodiam.LoginRESTAPI.model.Role;

abstract class RoleServiceImpl implements RoleService {

    @Override
    public Role findByRoleName(String roleName) {
        return new RoleServiceDal().findByRoleName(roleName);
    }
}
