package com.mree.app.core.service;

import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.exception.AppServiceException;
import com.mree.app.core.persist.User;

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
