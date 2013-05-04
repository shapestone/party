package com.xlenc.party;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * User: Michael Williams
 * Date: 8/20/12
 * Time: 9:52 PM
 */
@Configuration
@ComponentScan(basePackages = "com.xlenc.party", useDefaultFilters = true)
public class PartyConfig {

    public static final String DB_NAME = "party";

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    @Bean
    public Morphia morphia() {
        return new Morphia();
    }

    @Bean(name = "partyPersistence")
    public PartyPersistence partyPersistence() throws UnknownHostException {
        final BasicDAO<PartyImpl, Object> partyBasicDAO;
        partyBasicDAO = new BasicDAO<PartyImpl, Object>(PartyImpl.class, mongo(), morphia(), DB_NAME);

        final BasicDAO<PartyTypeOption, Object> partyTypeBasicDAO;
        partyTypeBasicDAO = new BasicDAO<PartyTypeOption, Object>(PartyTypeOption.class, mongo(), morphia(), DB_NAME);

        final BasicDAO<RelationshipImpl, Object> relationshipBasicDAO;
        relationshipBasicDAO = new BasicDAO<RelationshipImpl, Object>(RelationshipImpl.class, mongo(), morphia(), DB_NAME);

        final BasicDAO<RelationshipTypeOption, Object> relationshipTypeBasicDAO;
        relationshipTypeBasicDAO = new BasicDAO<RelationshipTypeOption, Object>(RelationshipTypeOption.class, mongo(), morphia(), DB_NAME);

        return new PartyPersistenceImpl(partyBasicDAO, partyTypeBasicDAO, relationshipBasicDAO, relationshipTypeBasicDAO);
    }

}
