package com.xlenc.party;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:54 PM
 */
public interface PartyPersistence {

    PartyData saveParty(PartyData partyData);

    PartyData findParty(PartyData partyData);

    int deleteParty(PartyData partyData);

}
