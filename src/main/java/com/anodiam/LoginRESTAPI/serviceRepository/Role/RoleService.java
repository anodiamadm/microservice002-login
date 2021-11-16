package com.anodiam.LoginRESTAPI.serviceRepository.Role;

import com.anodiam.LoginRESTAPI.model.Role;

public interface RoleService {
    Role findByRoleName(String roleName);
}
