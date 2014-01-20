package com.xlenc.party;

import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.mapping.Mapper;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;
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
        super.save(personData);
        return personData;
    }

    public PersonData updateParty(PersonData personData) {
        final UpdateOperations<PersonData> updateOperations = super.createUpdateOperations();
        updateOperations.set("firstName", personData.getFirstName());
        updateOperations.set("lastName", personData.getFirstName());
        Query<PersonData> query = super.createQuery();
        query.and(
                query.criteria("_id").equal(personData.getId()),
                query.criteria("version").equal(personData.getVersion())
        );
        super.update(query, updateOperations);
        return personData;
    }

    public PersonData findParty(PersonData personData) {
        return findOne(Mapper.ID_KEY, personData.getId());
    }

    public List<PersonData> findParties(final int limit, final int offSet) {
        return super.createQuery().limit(limit).offset(offSet).asList();
    }

    public int deleteParty(PersonData personData) {
        WriteResult writeResult = deleteById(new ObjectId(personData.getId()));
        return writeResult.getN();
    }

}
