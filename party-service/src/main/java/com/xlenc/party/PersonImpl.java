package com.xlenc.party;

import com.google.code.morphia.annotations.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/15/11
 * Time: 7:23 PM
 */
@EqualsAndHashCode(callSuper = false)
public @Data class PersonImpl extends PartyImpl implements Person {

    @Property("names")
    private Name[] names;

    @Property("dateOfBirth")
    private Date dateOfBirth;

    public PersonImpl() {
        super();
    }

    public PersonImpl(String id) {
        super(id);
    }

}
