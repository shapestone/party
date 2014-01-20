package com.xlenc.party;

import com.google.code.morphia.annotations.Property;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 5/4/13
 * Time: 1:44 PM
 */
public interface Person extends Party {

    String getFirstName();

    void setFirstName(String firstName);

    String getMiddleName();

    void setMiddleName(String middleName);

    String getLastName();

    void setLastName(String lastName);

    Date getDateOfBirth();

    void setDateOfBirth(java.util.Date dateOfBirth);
}
