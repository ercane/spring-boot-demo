
package com.mree.app.core.exception;

public class AppServiceException extends Exception {

    public AppServiceException(String msg) {
        super(msg);
    }

    public AppServiceException(Throwable t) {
        super(t);
    }

    public AppServiceException(String msg, Throwable t) {
        super(msg, t);
    }
}
