package com.mree.app.core.ws;

import com.mree.app.core.common.model.BaseInfo;
import com.mree.app.core.common.ws.ServiceUri;
import com.mree.app.core.exception.AppServiceException;
import com.mree.app.core.persist.BaseEntity;
import com.mree.app.core.service.IBaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** * @author MREE * * */
@CrossOrigin(origins = "*")
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
