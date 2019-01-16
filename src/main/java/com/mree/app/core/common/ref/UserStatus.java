
package com.mree.app.core.common.ref;

public enum UserStatus {
    CREATED(0, "Created"),
    ACTIVE(1, "Active"),
    PASSIVE(1, "Active");

    private Integer code;
    private String desc;

    UserStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserStatus get(Integer code) {
        for (UserStatus status : UserStatus.values()) {
            if (status.getCode().intValue() == code.intValue())
                return status;
        }

        throw new IllegalArgumentException();
    }
}
