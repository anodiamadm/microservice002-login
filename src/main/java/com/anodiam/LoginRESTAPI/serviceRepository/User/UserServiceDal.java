package com.anodiam.LoginRESTAPI.serviceRepository.User;

import com.anodiam.LoginRESTAPI.model.Role;
import com.anodiam.LoginRESTAPI.model.User;
import com.anodiam.LoginRESTAPI.model.common.MessageResponse;
import com.anodiam.LoginRESTAPI.model.common.ResponseCode;
import com.anodiam.LoginRESTAPI.serviceRepository.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class UserServiceDal extends UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public UserServiceDal(){}

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(username);
            if(optionalUser.isPresent()) {
                return optionalUser;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}