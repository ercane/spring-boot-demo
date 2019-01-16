
package com.mree.app.core.repo;

import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.persist.User;

import java.util.List;

/** * @author MREE * * */
public interface UserRepository extends BaseRepository<User, UserInfo> {

    List < User > findByUsername(String username);

    List < User > findByStatus(Integer code);
}
