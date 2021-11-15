package com.anodiam.LoginRESTAPI.repository.User;

import com.anodiam.LoginRESTAPI.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
