package com.xlenc.party;

import com.google.code.morphia.annotations.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: Michael Williams
 * Date: 1/15/11
 * Time: 7:29 PM
 */
@EqualsAndHashCode(callSuper = false)
public @Data class OrganizationImpl extends PartyImpl implements Organization {
    @Property("name")
    private String name;
    @Property("purpose")
    private String purpose;

    public OrganizationImpl() {
    }

    public OrganizationImpl(String id) {
        super(id);
    }


}
