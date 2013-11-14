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
public class PersonPersistence extends BasicDAO<PersonData, ObjectId> {

    public PersonPersistence(Mongo mongo, Morphia morphia, String databaseName) {
        super(mongo, morphia, databaseName);
    }

    public PersonData saveParty(PersonData personData) {
        personData.setId(new ObjectId().toString());
        return personData;
    }

    public PersonData findParty(PersonData personData) {
        return findOne(Mapper.ID_KEY, new ObjectId(personData.getId()));
    }

    public List<PersonData> findParties(final int limit, final int offSet) {
        return super.createQuery().limit(limit).offset(offSet).asList();
    }

    public int deleteParty(PersonData personData) {
        WriteResult writeResult = deleteById(new ObjectId(personData.getId()));
        return writeResult.getN();
    }

}
