package com.mree.app.core.persist;

import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.common.ref.UserStatus;

import javax.persistence.Entity;

/**
 * @author MREE * *
 */
@Entity
public class User extends BaseEntity<UserInfo> {
    private String username;
    private String password;
    private String name;
    private String surname;
    private Integer status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserStatus getStatus() {
        return UserStatus.get(status);
    }

    public void setStatus(UserStatus status) {
        this.status = status.getCode();
    }

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
        return i;
    }

    @Override
    public void fromInfo(UserInfo info) {
        setName(info.getName());
        setSurname(info.getSurname());
        setUsername(info.getUsername());
        setPassword(info.getPassword());
        setStatus(info.getStatus());
    }

}
