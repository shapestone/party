package com.xlenc.party;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 5/4/13
 * Time: 1:43 PM
 */
public interface Party {

    String getId();

    void setId(String id);

    PartyType getType();

    void setType(PartyType partyType);

    Date getLastModifiedDate();

    void setLastModifiedDate(Date lastModifiedDate);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Long getVersion();

    void setVersion(Long version);
}
