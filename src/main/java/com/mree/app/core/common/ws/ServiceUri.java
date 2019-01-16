package com.mree.app.core.common.ws;

/** * @author MREE * * */
public class ServiceUri {
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";

    public static final String ID_PARAM = "/{id}";
    public static final String MSG_PARAM = "/{msg}";
    public static final String ADD = "/add";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String LIST = "/list";

    public static final String DELETE_ID = DELETE + ID_PARAM;
    public static final String LIST_ID = LIST + ID_PARAM;

    public static final String USER = "/user";

}
