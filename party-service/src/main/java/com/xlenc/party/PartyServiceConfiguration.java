package com.xlenc.party;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User: Michael Williams
 * Date: 11/4/13
 * Time: 12:30 AM
 */
@EqualsAndHashCode(callSuper = false)
public @Data
class PartyServiceConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("mongoDatabase")
    private MongoDatabaseConfiguration mongoDatabaseConfiguration = new MongoDatabaseConfiguration();

}
