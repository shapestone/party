package com.xlenc.party;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User: Michael Williams
 * Date: 11/4/13
 * Time: 12:30 AM
 */
public class PartyServiceConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String partyDatabaseName;

    @NotEmpty
    @JsonProperty
    private String partyDatabaseHostName;

    @JsonProperty
    private int partyDatabasePort;

    public String getPartyDatabaseName() {
        return partyDatabaseName;
    }

    public String getPartyDatabaseHostName() {
        return partyDatabaseHostName;
    }

    public int getPartyDatabasePort() {
        return partyDatabasePort;
    }

}
