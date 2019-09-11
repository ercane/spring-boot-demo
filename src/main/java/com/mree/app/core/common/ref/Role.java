
package com.mree.app.core.common.ref;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_MANAGER,
    ROLE_USER;

    public String getAuthority() {
        return name();
    }

}
