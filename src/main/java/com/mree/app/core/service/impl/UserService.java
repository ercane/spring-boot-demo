package com.mree.app.core.service.impl;

import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.common.ref.Role;
import com.mree.app.core.common.ref.UserStatus;
import com.mree.app.core.config.JwtTokenProvider;
import com.mree.app.core.exception.AppServiceException;
import com.mree.app.core.exception.CustomException;
import com.mree.app.core.persist.User;
import com.mree.app.core.repo.UserRepository;
import com.mree.app.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MREE * *
 */

@Service
public class UserService extends BaseService<User, UserInfo> implements IUserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserRepository getRepo() {
        return repo;
    }

    @PostConstruct
    public void init() throws AppServiceException {
        /*First user*/

        List<User> system = getRepo().findByUsername("system");
        if (system == null || system.isEmpty()) {
            UserInfo i = new UserInfo();
            i.setName("System");
            i.setSurname("User");
            i.setPassword("system");
            i.setUsername("system");
            i.setStatus(UserStatus.ACTIVE);
            signup(i);
        }
    }

    @Override
    public User getEntity(UserInfo info) {
        User entity;
        if (info.getId() == null) {
            entity = new User();
        } else {
            entity = getRepo().findById(info.getId()).get();
        }

        return entity;
    }

    @Override
    public User prepareForCreate(UserInfo info) throws AppServiceException {
        validateFields(info);

        List<User> list = getRepo().findByUsername(info.getUsername());

        if (!list.isEmpty()) {
            throw new AppServiceException("There is already a username as " + info.getUsername());
        }

        User entity = new User();
        entity.fromInfo(info);
        return entity;
    }

    @Override
    public User prepareForUpdate(UserInfo info) throws AppServiceException {
        validateFields(info);

        if (info.getId() == null) {
            throw new AppServiceException("User cannot be found. Because there is no id ");
        }

        User entity = getRepo().findById(info.getId()).get();

        if (entity == null) {
            throw new AppServiceException("There is no a user with id " + info.getId());
        }

        entity.fromInfo(info);
        return entity;
    }

    @Override
    public void prepareForDelete(Long id) throws AppServiceException {

        if (id == null) {
            throw new AppServiceException("User cannot be found. Because there is no id ");
        }

        User entity = getRepo().findById(id).get();

        if (entity == null) {
            throw new AppServiceException("There is no user with id " + id);
        }
    }

    private void validateFields(UserInfo info) throws AppServiceException {
        if (!StringUtils.hasLength(info.getName())) {
            throw new AppServiceException("Name is required!");
        }

        if (!StringUtils.hasLength(info.getSurname())) {
            throw new AppServiceException("Surname is required!");
        }

        if (!StringUtils.hasLength(info.getUsername())) {
            throw new AppServiceException("Username is required!");
        }

        if (!StringUtils.hasLength(info.getPassword())) {
            throw new AppServiceException("Password is required!");
        }
    }

    @Override
    public User getByUsername(String username) throws AppServiceException {
        return getRepo().findByUsername(username).get(0);
    }

    @Override
    public String signup(UserInfo info) throws AppServiceException {
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        UserInfo create = create(info);
        return jwtTokenProvider.createToken(create.getUsername(), Arrays.asList(Role.ROLE_CLIENT));
    }

    @Override
    public String login(UserInfo info) throws AppServiceException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(info.getUsername(), info.getPassword()));
            return jwtTokenProvider.createToken(info.getUsername(), Arrays.asList(Role.ROLE_CLIENT));
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<UserInfo> getListByStatus(Integer code) throws AppServiceException {
        try {
            List<User> eList = getRepo().findByStatus(code);
            List<UserInfo> list = new ArrayList<>();
            for (User e : eList) {
                list.add(e.toInfo());
            }
            return list;
        } catch (Exception e) {
            throw new AppServiceException(e);
        }
    }

}
