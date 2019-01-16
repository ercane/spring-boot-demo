package com.mree.app.core.config;

import com.mree.app.core.common.ref.Role;
import com.mree.app.core.exception.AppServiceException;
import com.mree.app.core.persist.User;
import com.mree.app.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** * @author MREE * * */

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.getByUsername(username);
        } catch (AppServiceException e) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.getPassword())//
                .authorities(Role.ROLE_CLIENT.name())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }

}
