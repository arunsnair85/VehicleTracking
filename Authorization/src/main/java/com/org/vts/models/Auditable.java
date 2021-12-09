package com.org.vts.models;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// TODO: Auto-generated Javadoc
/**
 * The Class Auditable.
 *
 * @param <UserName> the generic type
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<UserName> {

    /** The created by. */
    @CreatedBy
    protected UserName createdBy;

    /** The created date. */
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    /** The last modified by. */
    @LastModifiedBy
    protected UserName lastModifiedBy;

    /** The last modified date. */
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

    /**
     * Gets the created by.
     *
     * @return the created by
     */
    public UserName getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the created by.
     *
     * @param createdBy the new created by
     */
    public void setCreatedBy(UserName createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the created date.
     *
     * @return the created date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date.
     *
     * @param createdDate the new created date
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the last modified by.
     *
     * @return the last modified by
     */
    public UserName getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Sets the last modified by.
     *
     * @param lastModifiedBy the new last modified by
     */
    public void setLastModifiedBy(UserName lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * Gets the last modified date.
     *
     * @return the last modified date
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Sets the last modified date.
     *
     * @param lastModifiedDate the new last modified date
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
