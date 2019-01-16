
/* * * Project: mysql-spring-boot-todo * Date Created: 19 Ara 2018 * Created By: MREE */
package com.mree.todo.core.exception;

import org.springframework.http.HttpStatus;

/** * @author MREE * * */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public CustomException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
