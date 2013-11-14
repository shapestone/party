package com.xlenc.party;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:56 PM
 */
public class PartyServiceImpl implements PartyService {

    private PartyPersistence partyPersistence;

    public PartyServiceImpl(PartyPersistence partyPersistence) {
        this.partyPersistence = partyPersistence;
    }

    @Override
    public Person add(Person person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        PartyType partyType = person.getType();
        notNull(partyType, "Party type cannot be null.");
        notNull(partyType.getName(), "Party Type name cannot be null.");
        //return (Person)partyPersistence.saveParty(person);
        throw new UnsupportedOperationException();
    }

    @Override
    public Person addEmptyPerson() {
        return (Person)partyPersistence.saveParty(new PersonData());
    }

    @Override
    public Person read(Person person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        //return (Person)partyPersistence.findParty(person);
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Person person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        //return partyPersistence.delete(person);
        throw new UnsupportedOperationException();
    }

    @Override
    public Organization add(Organization organization) {
        notNull(organization, "Parameter \"organization\" cannot be null.");
        PartyType partyType = organization.getType();
        notNull(partyType, "Party type cannot be null.");
        notNull(partyType.getName(), "Party Type name cannot be null.");
        //return (Organization)partyPersistence.saveParty(organization);
        throw new UnsupportedOperationException();
    }

    @Override
    public Organization read(Organization organization) {
        notNull(organization, "Parameter \"organization\" cannot be null.");
        //return (Organization)partyPersistence.findParty(organization);
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(Organization organization) {
        notNull(organization, "Parameter \"organization\" cannot be null.");
        //return partyPersistence.delete(organization);
        throw new UnsupportedOperationException();
    }

}
