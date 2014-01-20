package com.xlenc.party;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/15/11
 * Time: 7:23 PM
 */
@Entity("persons")
@EqualsAndHashCode(callSuper = false)
public @Data class PersonData extends PartyData implements Person {

    @Property("firstName")
    private String firstName;
    @Property("middleName")
    private String middleName;
    @Property("lastName")
    private String lastName;
    @Property("dateOfBirth")
    private Date dateOfBirth;

    public PersonData() {
        super();
    }

    public PersonData(String id) {
        super(id);
    }

}
