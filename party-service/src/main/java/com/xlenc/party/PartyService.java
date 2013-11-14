package com.xlenc.party;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:52 PM
 */
public interface PartyService {

    Person add(Person person);

    Person addEmptyPerson();

    Person read(Person person);

    int delete(Person person);

    Organization add(Organization organization);

    Organization read(Organization organization);

    int delete(Organization organization);

}
