
/* * * Project: mysql-spring-boot-todo * Date Created: 13 Ara 2018 * Created By: MREE */
package com.mree.todo.core.service;

import java.util.List;

import com.mree.todo.core.common.model.BaseInfo;
import com.mree.todo.core.exception.AppServiceException;
import com.mree.todo.core.persist.BaseEntity;

/**
 * @author MREE * *
 */
public interface IBaseService<E extends BaseEntity<I>, I extends BaseInfo> {

    I getById(Long id) throws AppServiceException;

    I create(I info) throws AppServiceException;

    I update(I info) throws AppServiceException;

    void delete(Long id) throws AppServiceException;

    List<I> getList() throws AppServiceException;

 }
