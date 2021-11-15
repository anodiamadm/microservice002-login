package com.anodiam.LoginRESTAPI.repository.Role;

import com.anodiam.LoginRESTAPI.model.Role;

public interface RoleService {
    Role findByRoleName(String roleName);
}
