package com.mree.app.core.service;

import com.mree.app.core.common.model.BaseInfo;
import com.mree.app.core.exception.AppServiceException;
import com.mree.app.core.persist.BaseEntity;

import java.util.List;

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
