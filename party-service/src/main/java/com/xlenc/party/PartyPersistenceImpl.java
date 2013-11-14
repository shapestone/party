package com.xlenc.party;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.mapping.Mapper;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * User: Michael Williams
 * Date: 11/29/12
 * Time: 11:25 PM
 */
public class PartyPersistenceImpl extends BasicDAO<PartyData, ObjectId> implements PartyPersistence {


    public PartyPersistenceImpl(Mongo mongo, Morphia morphia, String databaseName) {
        super(mongo, morphia, databaseName);
    }

    public PartyData saveParty(PartyData partyData) {
        partyData.setId(new ObjectId().toString());
        return partyData;
    }

    public PartyData findParty(PartyData partyData) {
        return findOne(Mapper.ID_KEY, new ObjectId(partyData.getId()));
    }

    public List<PartyData> findParties(final int limit, final int offSet) {
        return super.createQuery().limit(limit).offset(offSet).asList();
    }

    public int deleteParty(PartyData partyData) {
        WriteResult writeResult = deleteById(new ObjectId(partyData.getId()));
        return writeResult.getN();
    }


}
