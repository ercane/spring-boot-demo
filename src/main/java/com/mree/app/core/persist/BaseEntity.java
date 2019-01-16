package com.mree.app.core.persist;

import com.mree.app.core.common.model.BaseInfo;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity < I extends BaseInfo > {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        updatedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public abstract I toInfo();

    public abstract void fromInfo(I info);
}
