package com.mree.app.core.common.model;

import com.mree.app.core.common.ref.Role;
import com.mree.app.core.common.ref.UserStatus;
import lombok.Data;

/**
 * @author MREE * *
 */
@Data
public class UserInfo extends BaseInfo {
    private String username;
    private String password;
    private String name;
    private String surname;
    private UserStatus status;
    private Role role;

}
