
/* * * Project: mysql-spring-boot-todo * Date Created: 13 Ara 2018 * Created By: MREE */
package com.mree.todo.core.service;

import com.mree.todo.core.common.model.UserInfo;
import com.mree.todo.core.exception.AppServiceException;
import com.mree.todo.core.persist.User;

import java.util.List;

/**
 * @author MREE * *
 */
public interface IUserService extends IBaseService<User, UserInfo> {

    User getByUsername(String username) throws AppServiceException;

    String signup(UserInfo info) throws AppServiceException;

    String login(UserInfo info) throws AppServiceException;

    List<UserInfo> getListByStatus(Integer code) throws AppServiceException;

}
