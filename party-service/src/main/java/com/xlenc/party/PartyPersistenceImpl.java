package com.xlenc.party;

import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.mapping.Mapper;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;

/**
 * User: Michael Williams
 * Date: 11/29/12
 * Time: 11:25 PM
 */
public class PartyPersistenceImpl extends BasicDAO<PartyImpl, ObjectId> implements PartyPersistence {

    private BasicDAO<PartyImpl, Object> partyBasicDAO;
    private BasicDAO<PartyTypeOption, Object> partyTypeOptionBasicDAO;
    private BasicDAO<RelationshipImpl, Object> relationshipBasicDAO;
    private BasicDAO<RelationshipTypeOption, Object> relationshipTypeOptionBasicDAO;

//    public PartyPersistenceImpl(BasicDAO<PartyImpl, Object> partyBasicDAO,
//                                BasicDAO<PartyTypeOption, Object> partyTypeOptionBasicDAO,
//                                BasicDAO<RelationshipImpl, Object> relationshipBasicDAO,
//                                BasicDAO<RelationshipTypeOption, Object> relationshipTypeOptionBasicDAO) {
//
//        this.partyBasicDAO = partyBasicDAO;
//        this.partyTypeOptionBasicDAO = partyTypeOptionBasicDAO;
//        this.relationshipBasicDAO = relationshipBasicDAO;
//        this.relationshipTypeOptionBasicDAO = relationshipTypeOptionBasicDAO;
//    }

    public PartyPersistenceImpl(Mongo mongo, Morphia morphia, String databaseName) {
        super(mongo, morphia, databaseName);
    }

    public Party add(Party party) {
        Key<PartyImpl> newParty = partyBasicDAO.save((PartyImpl)party);
        Object id = newParty.getId();
        party.setId(id.toString());
        return party;
    }

    @Override
    public Party read(Party party) {
        return partyBasicDAO.findOne(Mapper.ID_KEY, new ObjectId(party.getId()));
    }

    @Override
    public int delete(Party party) {
        WriteResult writeResult = partyBasicDAO.deleteById(new ObjectId(party.getId()));
        return writeResult.getN();
    }

    public PartyTypeOption add(PartyTypeOption partyTypeOption) {
        Key<PartyTypeOption> newPartyTypeOption = partyTypeOptionBasicDAO.save(partyTypeOption);
        Object id = newPartyTypeOption.getId();
        partyTypeOption.setId(id.toString());
        return partyTypeOption;
    }

    @Override
    public PartyTypeOption read(PartyTypeOption partyTypeOption) {
        return partyTypeOptionBasicDAO.findOne(Mapper.ID_KEY, new ObjectId(partyTypeOption.getId()));
    }

    @Override
    public int delete(PartyTypeOption partyTypeOption) {
        WriteResult writeResult = partyTypeOptionBasicDAO.deleteById(new ObjectId(partyTypeOption.getId()));
        return writeResult.getN();
    }

    public RelationshipTypeOption add(RelationshipTypeOption relationshipTypeOption) {
        Key<RelationshipTypeOption> relationshipTypeOptionKey = relationshipTypeOptionBasicDAO.save(relationshipTypeOption);
        Object id = relationshipTypeOptionKey.getId();
        relationshipTypeOption.setId(id.toString());
        return relationshipTypeOption;
    }

    @Override
    public RelationshipTypeOption read(RelationshipTypeOption relationshipTypeOption) {
        return relationshipTypeOptionBasicDAO.findOne(Mapper.ID_KEY, new ObjectId(relationshipTypeOption.getId()));
    }

    @Override
    public int delete(RelationshipTypeOption relationshipType) {
        WriteResult delete = relationshipTypeOptionBasicDAO.deleteById(new ObjectId(relationshipType.getId()));
        return delete.getN();
    }

    public Relationship add(Relationship relationship) {
        Key<RelationshipImpl> relationshipKey = relationshipBasicDAO.save((RelationshipImpl)relationship);
        Object id = relationshipKey.getId();
        relationship.setId(id.toString());
        return relationship;
    }

    public Relationship read(Relationship relationship) {
        return relationshipBasicDAO.findOne(Mapper.ID_KEY, new ObjectId(relationship.getId()));
    }

    @Override
    public int delete(Relationship relationship) {
        WriteResult writeResult = relationshipBasicDAO.deleteById(new ObjectId(relationship.getId()));
        return writeResult.getN();
    }

}
