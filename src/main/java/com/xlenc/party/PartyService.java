package com.xlenc.party;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:52 PM
 */
public interface PartyService {

    PartyTypeOption add(PartyTypeOption partyTypeOption);

    PartyTypeOption read(PartyTypeOption partyTypeOption);

    int delete(PartyTypeOption partyTypeOption);

    Person add(Person person);

    Person addEmptyPerson();

    Person read(Person person);

    int delete(Person person);

    Organization add(Organization organization);

    Organization read(Organization organization);

    int delete(Organization organization);

    RelationshipTypeOption add(RelationshipTypeOption relationshipTypeOption);

    RelationshipTypeOption read(RelationshipTypeOption relationshipTypeOption);

    int delete(RelationshipTypeOption relationshipTypeOption);

    Relationship add(Relationship partyRelationship);

    Relationship read(Relationship relationship);

    int delete(Relationship relationship);

}
