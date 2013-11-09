package com.xlenc.party;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.xlenc.party.rest.PartyResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import java.net.UnknownHostException;

/**
 * User: Michael Williams
 * Date: 11/4/13
 * Time: 12:54 AM
 */
public class PartyRestService extends Service<PartyServiceConfiguration> {

    @Override
    public void initialize(Bootstrap<PartyServiceConfiguration> bootstrap) {
        bootstrap.setName("Party Rest Service");
    }

    @Override
    public void run(PartyServiceConfiguration configuration, Environment environment) throws Exception {
        setUpPartyService(configuration, environment);
    }

    private void setUpPartyService(PartyServiceConfiguration configuration, Environment environment) throws UnknownHostException {
        final String hostName = configuration.getPartyDatabaseHostName();
        final int port = configuration.getPartyDatabasePort();
        final Mongo mongo = new MongoClient(hostName, port);
        final Morphia morphia = new Morphia();

        final String databaseName = configuration.getPartyDatabaseName();
        final PartyPersistence partyPersistence;
        partyPersistence = new PartyPersistenceImpl(mongo, morphia, databaseName);

        final PartyService partyService = new PartyServiceImpl(partyPersistence);
        final PartyResource questionRestResource = new PartyResource(partyService);
//        environment.addResource(questionRestResource);
//        environment.addHealthCheck(new MongoHealthCheck(mongo));
    }

}
