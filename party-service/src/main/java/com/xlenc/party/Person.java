package com.xlenc.party;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 5/4/13
 * Time: 1:44 PM
 */
public interface Person extends Party {

    PersonalName getPersonalName();

    void setPersonalName(PersonalName personalName);

    Date getDateOfBirth();

    void setDateOfBirth(java.util.Date dateOfBirth);
}
