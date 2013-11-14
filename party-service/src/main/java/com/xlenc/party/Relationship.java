package com.xlenc.party;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 5/4/13
 * Time: 1:44 PM
 */
public interface Relationship {

    String getId();

    void setId(String id);

    RelationshipType getType();

    void setType(RelationshipType type);

    Party getFirstRole();

    void setFirstRole(Party firstRole);

    Party getSecondRole();

    void setSecondRole(Party secondRole);

    Date getEffectiveDate();

    void setEffectiveDate(Date effectiveDate);

    Date getUntilDate();

    void setUntilDate(Date untilDate);

    Date getLastModifiedDate();

    void setLastModifiedDate(Date lastModifiedDate);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Long getVersion();

    void setVersion(Long version);
}
