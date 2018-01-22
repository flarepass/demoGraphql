package com.example.demographql.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1274598910052793222L;
    @Column(name = "created_by")
    @CreatedBy
    protected Long createdBy;

    @Column(name = "created_at")
    @CreatedDate
    protected Long createdDate;

    @Column(name = "updated_by")
    @LastModifiedBy
    protected Long updatedBy;

    @Column(name = "updated_at")
    @LastModifiedDate
    protected Long updatedDate;

}
