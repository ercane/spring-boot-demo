package com.mree.app.core.persist;

import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.common.ref.Role;
import com.mree.app.core.common.ref.UserStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author MREE * *
 */
@Data
@Entity
public class User extends BaseEntity<UserInfo> {
    private String username;
    private String password;
    private String name;
    private String surname;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @Enumerated(value = EnumType.STRING)
    private Role role;




    @Override
    public UserInfo toInfo() {
        UserInfo i = new UserInfo();
        i.setCreatedDate(getCreatedDate());
        i.setId(getId());
        i.setName(getName());
        i.setSurname(getSurname());
        i.setUpdatedDate(getUpdatedDate());
        i.setUsername(username);
        i.setStatus(getStatus());
        i.setRole(getRole());
        return i;
    }

    @Override
    public void fromInfo(UserInfo info) {
        setName(info.getName());
        setSurname(info.getSurname());
        setUsername(info.getUsername());
        setPassword(info.getPassword());
        setStatus(info.getStatus());
        setRole(info.getRole());
    }

}
