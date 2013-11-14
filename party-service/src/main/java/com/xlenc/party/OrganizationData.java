package com.xlenc.party;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: Michael Williams
 * Date: 1/15/11
 * Time: 7:29 PM
 */
@Entity("organizations")
@EqualsAndHashCode(callSuper = false)
public @Data class OrganizationData extends PartyData implements Organization {
    @Property("name")
    private String name;
    @Property("purpose")
    private String purpose;

    public OrganizationData() {
    }

    public OrganizationData(String id) {
        super(id);
    }


}
