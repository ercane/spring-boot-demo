
/* * * Project: mysql-spring-boot-todo * Date Created: 13 Ara 2018 * Created By: MREE */
package com.mree.todo.core.persist;

import javax.persistence.Entity;

import com.mree.todo.core.common.model.UserInfo;
import com.mree.todo.core.common.ref.UserStatus;

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
        return i;
    }

    @Override
    public void fromInfo(UserInfo info) {
        setName(info.getName());
        setSurname(info.getSurname());
        setUsername(info.getUsername());
        setPassword(info.getPassword());
    }

}
