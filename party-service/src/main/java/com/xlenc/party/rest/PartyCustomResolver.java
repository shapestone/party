package com.xlenc.party.rest;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlenc.party.PartyCustomModule;

import javax.ws.rs.ext.ContextResolver;

/**
 * User: Michael Williams
 * Date: 1/27/13
 * Time: 2:33 PM
 */
public class PartyCustomResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;
    private final String name;
    private final Version version;

    public PartyCustomResolver() {
        this.objectMapper = new ObjectMapper();
        this.name = "PartyCustomModule";
        this.version = new Version(1, 0, 0, "SNAPSHOT");
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        objectMapper.registerModule(new PartyCustomModule(name, version));
        return objectMapper;
    }
}
