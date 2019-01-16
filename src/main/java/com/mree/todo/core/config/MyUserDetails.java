
/* * * Project: mysql-spring-boot-todo * Date Created: 19 Ara 2018 * Created By: MREE */
package com.mree.todo.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mree.todo.core.common.ref.Role;
import com.mree.todo.core.exception.AppServiceException;
import com.mree.todo.core.persist.User;
import com.mree.todo.core.service.IUserService;

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
