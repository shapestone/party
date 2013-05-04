package com.xlenc.party;

import com.google.code.morphia.annotations.*;
import com.google.code.morphia.utils.IndexDirection;
import lombok.Data;

import java.util.Date;

/**
 * Date: 1/23/11
 * Time: 3:48 PM
 */
@Entity("partytypeoptions")
public @Data class PartyTypeOption {

    @Id
    private String id;
    @Property("name")
    @Indexed(value= IndexDirection.ASC, name="idx_name", unique=true, dropDups=true)
    private String name;
    @Property("lastModifiedDate")
    private Date lastModifiedDate;
    @Property("createdDate")
    private Date createdDate;
    @Version
    private Long version;

    public PartyTypeOption() {
    }

    public PartyTypeOption(String id) {
        this.id = id;
    }

}
