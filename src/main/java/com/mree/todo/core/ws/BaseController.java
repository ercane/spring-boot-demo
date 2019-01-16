
/* * * Project: mysql-spring-boot-todo * Date Created: 13 Ara 2018 * Created By: MREE */
package com.mree.todo.core.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mree.todo.core.common.model.BaseInfo;
import com.mree.todo.core.common.ws.ServiceUri;
import com.mree.todo.core.exception.AppServiceException;
import com.mree.todo.core.persist.BaseEntity;
import com.mree.todo.core.service.IBaseService;

/** * @author MREE * * */
@CrossOrigin(origins = "http://localhost:63342")
public abstract class BaseController < E extends BaseEntity < I >, I extends BaseInfo, S extends IBaseService < E, I > > {

    public abstract IBaseService < E, I > getService();

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.ID_PARAM, method = RequestMethod.GET)
    public I getById(@PathVariable Long id) throws AppServiceException {
        return getService().getById(id);
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.ADD, method = RequestMethod.POST)
    I create(@RequestBody I info) throws AppServiceException {
        return getService().create(info);
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.UPDATE, method = RequestMethod.POST)
    I update(@RequestBody I info) throws AppServiceException {
        return getService().update(info);
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.LIST, method = RequestMethod.GET)
    List < I > getList() throws AppServiceException {
        return getService().getList();
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.DELETE_ID, method = RequestMethod.DELETE)
    void delete(@PathVariable Long id) throws AppServiceException {
        getService().delete(id);
    }

}
