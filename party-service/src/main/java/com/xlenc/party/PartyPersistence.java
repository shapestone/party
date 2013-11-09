package com.xlenc.party;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:54 PM
 */
public interface PartyPersistence {

    Party add(Party party);

    Party read(Party party);

    int delete(Party party);

    PartyTypeOption add(PartyTypeOption partyTypeOption);

    PartyTypeOption read(PartyTypeOption partyTypeOption);

    int delete(PartyTypeOption partyTypeOption);

    RelationshipTypeOption add(RelationshipTypeOption relationshipTypeOption);

    RelationshipTypeOption read(RelationshipTypeOption relationshipTypeOption);

    int delete(RelationshipTypeOption relationshipTypeOption);

    Relationship add(Relationship relationship);

    Relationship read(Relationship relationship);

    int delete(Relationship relationship);

}
