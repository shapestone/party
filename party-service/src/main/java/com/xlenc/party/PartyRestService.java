package com.xlenc.party;

import com.fasterxml.jackson.core.Version;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.xlenc.party.rest.OrganizationResource;
import com.xlenc.party.rest.PersonResource;
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
        final String name = "PartyCustomModule";
        final Version snapshot = new Version(1, 0, 0, "SNAPSHOT", "com.xlenc.party", "party-service");
        final PartyCustomModule partyCustomModule = new PartyCustomModule(name, snapshot);
        bootstrap.getObjectMapperFactory().registerModule(partyCustomModule);
    }

    @Override
    public void run(PartyServiceConfiguration configuration, Environment environment) throws Exception {
        final MongoDatabaseConfiguration mongoDatabaseConfiguration = configuration.getMongoDatabaseConfiguration();
        final String host = mongoDatabaseConfiguration.getHost();
        final int port = mongoDatabaseConfiguration.getPort();
        final Mongo mongo = new MongoClient(host, port);
        final Morphia morphia = new Morphia();
        final String databaseName = mongoDatabaseConfiguration.getDatabaseName();

        wirePersonService(environment, mongo, morphia, databaseName);
        wireOrganizationService(environment, mongo, morphia, databaseName);
        wireHealthChecks(environment, mongo);
    }

    private void wirePersonService(Environment environment, Mongo mongo, Morphia morphia, String databaseName) throws UnknownHostException {
        final PersonPersistence personPersistence = new PersonPersistence(mongo, morphia, databaseName);
        final PersonService personService = new PersonService(personPersistence);
        final PersonResource personResource = new PersonResource(personService);
        environment.addResource(personResource);
    }

    private void wireOrganizationService(Environment environment, Mongo mongo, Morphia morphia, String databaseName) throws UnknownHostException {
        final OrganizationPersistence organizationPersistence = new OrganizationPersistence(mongo, morphia, databaseName);
        final OrganizationService organizationService = new OrganizationService(organizationPersistence);
        final OrganizationResource organizationResource = new OrganizationResource(organizationService);
        environment.addResource(organizationResource);
    }

    private void wireHealthChecks(Environment environment, Mongo mongo) {
        environment.addHealthCheck(new MongoHealthCheck(mongo));
    }

    public static void main(String[] args) throws Exception {
        new PartyRestService().run(args);
    }

}
