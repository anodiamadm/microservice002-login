package com.anodiam.LoginRESTAPI.repository.User;

import com.anodiam.LoginRESTAPI.model.User;

import java.util.Optional;

abstract class UserServiceImpl implements UserService {

    @Override
    public Optional<User> findByUsername(String username) {
        return new UserServiceDal().findByUsername(username);
    }
}
