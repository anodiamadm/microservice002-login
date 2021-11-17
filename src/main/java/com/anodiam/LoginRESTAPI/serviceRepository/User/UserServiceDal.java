package com.anodiam.LoginRESTAPI.serviceRepository.User;

import com.anodiam.LoginRESTAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
            String enocdedUserName=new GeneralEncoderDecoder().encrypt(username);
            Optional<User> optionalUser = userRepository.findByUsername(enocdedUserName);
            if(optionalUser.isPresent()) {
                return optionalUser;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
