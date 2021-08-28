package com.anodiam.LoginRESTAPI.db.Repository;

import com.anodiam.LoginRESTAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
