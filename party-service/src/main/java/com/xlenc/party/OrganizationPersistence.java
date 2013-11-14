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
public class OrganizationPersistence extends BasicDAO<OrganizationData, ObjectId> {

    public OrganizationPersistence(Mongo mongo, Morphia morphia, String databaseName) {
        super(mongo, morphia, databaseName);
    }

    public OrganizationData saveParty(OrganizationData organizationData) {
        organizationData.setId(new ObjectId().toString());
        return organizationData;
    }

    public OrganizationData findParty(OrganizationData organizationData) {
        return findOne(Mapper.ID_KEY, new ObjectId(organizationData.getId()));
    }

    public List<OrganizationData> findParties(final int limit, final int offSet) {
        return super.createQuery().limit(limit).offset(offSet).asList();
    }

    public int deleteParty(OrganizationData organizationData) {
        WriteResult writeResult = deleteById(new ObjectId(organizationData.getId()));
        return writeResult.getN();
    }


}
