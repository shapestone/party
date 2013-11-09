package com.xlenc.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:56 PM
 */
@Component
public class PartyServiceImpl implements PartyService {

    @Autowired
    private PartyPersistence partyPersistence;

    public PartyServiceImpl(PartyPersistence partyPersistence) {
        this.partyPersistence = partyPersistence;
    }

    @Override
    public PartyTypeOption add(PartyTypeOption partyTypeOption) {
        return partyPersistence.add(partyTypeOption);
    }

    @Override
    public PartyTypeOption read(PartyTypeOption partyTypeOption) {
        return partyPersistence.read(partyTypeOption);
    }

    @Override
    public int delete(PartyTypeOption partyTypeOption) {
        return partyPersistence.delete(partyTypeOption);
    }

    @Override
    public Person add(Person person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        PartyType partyType = person.getType();
        notNull(partyType, "Party type cannot be null.");
        notNull(partyType.getName(), "Party Type name cannot be null.");
        return (Person)partyPersistence.add(person);
    }

    @Override
    public Person addEmptyPerson() {
        return (Person)partyPersistence.add(new PersonImpl());
    }

    @Override
    public Person read(Person person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        return (Person)partyPersistence.read(person);
    }

    @Override
    public int delete(Person person) {
        notNull(person, "Parameter \"person\" cannot be null.");
        return partyPersistence.delete(person);
    }

    @Override
    public Organization add(Organization organization) {
        notNull(organization, "Parameter \"organization\" cannot be null.");
        PartyType partyType = organization.getType();
        notNull(partyType, "Party type cannot be null.");
        notNull(partyType.getName(), "Party Type name cannot be null.");
        return (Organization)partyPersistence.add(organization);
    }

    @Override
    public Organization read(Organization organization) {
        notNull(organization, "Parameter \"organization\" cannot be null.");
        return (Organization)partyPersistence.read(organization);
    }

    @Override
    public int delete(Organization organization) {
        notNull(organization, "Parameter \"organization\" cannot be null.");
        return partyPersistence.delete(organization);
    }

    @Override
    public RelationshipTypeOption add(RelationshipTypeOption relationshipTypeOption) {
        return partyPersistence.add(relationshipTypeOption);
    }

    @Override
    public RelationshipTypeOption read(RelationshipTypeOption relationshipTypeOption) {
        return partyPersistence.read(relationshipTypeOption);
    }

    @Override
    public int delete(RelationshipTypeOption relationshipTypeOption) {
        return partyPersistence.delete(relationshipTypeOption);
    }

    @Override
    public Relationship add(Relationship relationship) {
        notNull(relationship, "Parameter \"relationship\" cannot be null.");

        Party firstRole = relationship.getFirstRole();
        notNull(firstRole, "Relationship \"firstRole\" cannot be null.");

        Party secondRole = relationship.getSecondRole();
        notNull(firstRole, "Relationship \"secondRole\" cannot be null.");

        RelationshipType relationshipType = relationship.getType();
        notNull(relationshipType, "Relationship type cannot be null.");

        notNull(relationshipType.getName(), "Relationship type name cannot be null.");

        // Add the party in the first role if an id does not exists
        if (firstRole.getId() == null) {
            partyPersistence.add(firstRole);
        }

        // Add the party in the second role if an id does not exists
        if (secondRole.getId() == null) {
            partyPersistence.add(secondRole);
        }

        if (firstRole instanceof Person && secondRole instanceof Person) {
            isTrue(firstRole.equals(secondRole));
        }

        if (firstRole instanceof Organization && secondRole instanceof Organization) {
            isTrue(firstRole.equals(secondRole));
        }

        return partyPersistence.add(relationship);
    }

    @Override
    public Relationship read(Relationship relationship) {
        return partyPersistence.read(relationship);
    }

    @Override
    public int delete(Relationship relationship) {
        return partyPersistence.delete(relationship);
    }

}
