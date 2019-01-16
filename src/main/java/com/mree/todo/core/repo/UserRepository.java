
/* * * Project: mysql-spring-boot-todo * Date Created: 13 Ara 2018 * Created By: MREE */
package com.mree.todo.core.repo;

import java.util.List;

import com.mree.todo.core.common.model.UserInfo;
import com.mree.todo.core.persist.User;

/** * @author MREE * * */
public interface UserRepository extends BaseRepository < User, UserInfo > {

    List < User > findByUsername(String username);

    List < User > findByStatus(Integer code);
}
