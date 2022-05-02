package com.anodiam.LoginRESTAPI.serviceRepository.Role;

import com.anodiam.LoginRESTAPI.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(String roleName);
}
