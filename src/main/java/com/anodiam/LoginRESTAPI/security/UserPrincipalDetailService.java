package com.anodiam.LoginRESTAPI.security;

import com.anodiam.LoginRESTAPI.serviceRepository.User.UserRepository;
import com.anodiam.LoginRESTAPI.serviceRepository.User.UserService;
import com.anodiam.LoginRESTAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Handle User Not Found exception here *****
        User user = this.userRepository.findByUsername(s).get();
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }
}
