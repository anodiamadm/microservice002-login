package com.anodiam.LoginRESTAPI.db;

import com.anodiam.LoginRESTAPI.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
