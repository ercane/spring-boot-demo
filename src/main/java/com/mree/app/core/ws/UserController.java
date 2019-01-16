package com.mree.app.core.ws;

import com.mree.app.core.common.model.UserInfo;
import com.mree.app.core.common.ws.ServiceUri;
import com.mree.app.core.config.Token;
import com.mree.app.core.exception.AppServiceException;
import com.mree.app.core.persist.User;
import com.mree.app.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MREE * *
 */

@RestController
@RequestMapping(path = ServiceUri.USER)
public class UserController extends BaseController<User, UserInfo, IUserService> {

    @Autowired
    private IUserService service;

    @Override
    public IUserService getService() {
        return service;
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.SIGNUP, method = RequestMethod.POST)
    public Token signup(@RequestBody UserInfo info) throws AppServiceException {
        String token = getService().signup(info);
        return new Token(token);
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.LOGIN, method = RequestMethod.POST)
    public Token login(@RequestBody UserInfo info) throws AppServiceException {
        String token = getService().login(info);
        return new Token(token);
    }

    @ResponseBody
    @RequestMapping(path = ServiceUri.LIST_ID, method = RequestMethod.GET)
    List<UserInfo> getListByStatus(@PathVariable Integer id) throws AppServiceException {
        return getService().getListByStatus(id);
    }

}
