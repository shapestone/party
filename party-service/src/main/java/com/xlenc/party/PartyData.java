package com.xlenc.party;

import com.google.code.morphia.annotations.*;
import lombok.Data;
import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/15/11
 * Time: 7:16 PM
 */
public @Data class PartyData implements Party {

    @Id
    private String id;
    @Embedded
    private PartyType type;
    @Property("lastModifiedDate")
    private Date lastModifiedDate;
    @Property("createdDate")
    private Date createdDate;
    @Version
    private Long version;

    public PartyData() {
    }

    public PartyData(String id) {
        super();
        this.id = id;
    }

}
