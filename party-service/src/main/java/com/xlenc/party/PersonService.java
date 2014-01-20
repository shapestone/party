package com.xlenc.party;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:56 PM
 */
public class PersonService {

    private PersonPersistence personPersistence;

    public PersonService(PersonPersistence personPersistence) {
        this.personPersistence = personPersistence;
    }

    public PersonData add(PersonData person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        return personPersistence.saveParty(person);
    }

    public Person addEmptyPerson() {
        return personPersistence.saveParty(new PersonData());
    }

    public PersonData update(PersonData person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        return personPersistence.updateParty(person);
    }

    public PersonData read(PersonData personData) {
        notNull(personData, "Parameter \"person\" cannot be null.");
        return personPersistence.findParty(personData);
    }

    public int delete(PersonData person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        return personPersistence.deleteParty(person);
    }

}
