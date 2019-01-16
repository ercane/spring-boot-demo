
package com.mree.todo.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mree.todo.core.common.model.BaseInfo;
import com.mree.todo.core.exception.AppServiceException;
import com.mree.todo.core.persist.BaseEntity;
import com.mree.todo.core.repo.BaseRepository;
import com.mree.todo.core.service.IBaseService;

public abstract class BaseService < E extends BaseEntity < I >, I extends BaseInfo > implements IBaseService < E, I > {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    public abstract BaseRepository < E, I > getRepo();

    public abstract E getEntity(I info);

    public abstract E prepareForCreate(I info) throws AppServiceException;

    public abstract E prepareForUpdate(I info) throws AppServiceException;

    public abstract void prepareForDelete(Long id) throws AppServiceException;

    @Override
    public I getById(Long id) throws AppServiceException {
        E entity = getRepo().findOne(id);
        return entity.toInfo();
    }

    @Override
    public I create(I info) throws AppServiceException {
        try {
            E entity = prepareForCreate(info);
            entity = getRepo().save(entity);
            return entity.toInfo();
        } catch (Exception e) {
            throw new AppServiceException(e);
        }
    }

    @Override
    public I update(I info) throws AppServiceException {
        try {
            E entity = prepareForUpdate(info);
            entity = getRepo().save(entity);
            return entity.toInfo();
        } catch (Exception e) {
            throw new AppServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws AppServiceException {
        try {
            prepareForDelete(id);
            getRepo().delete(id);
        } catch (Exception e) {
            throw new AppServiceException(e);
        }
    }

    @Override
    public List < I > getList() throws AppServiceException {
        try {
            List < E > eList = (List < E >) getRepo().findAll();
            List < I > list = new ArrayList <>();
            for (E e : eList) {
                list.add(e.toInfo());
            }
            return list;
        } catch (Exception e) {
            throw new AppServiceException(e);
        }
    }

}
