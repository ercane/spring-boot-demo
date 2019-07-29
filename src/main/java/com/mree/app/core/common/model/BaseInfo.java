
package com.mree.app.core.common.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseInfo {

    private Long id;
    private Date createdDate;
    private Date updatedDate;

}
