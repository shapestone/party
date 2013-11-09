package com.xlenc.party;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Version;
import lombok.Data;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/23/11
 * Time: 3:48 PM
 */
@Entity("relationshiptypeoptions")
public @Data class RelationshipTypeOption {

    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("lastModifiedDate")
    private Date lastModifiedDate;
    @Property("createdDate")
    private Date createdDate;
    @Version
    private Long version;

    public RelationshipTypeOption() {
    }

    public RelationshipTypeOption(String id) {
        this.id = id;
    }
}
