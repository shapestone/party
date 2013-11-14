package com.xlenc.party;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

import com.fasterxml.jackson.databind.module.SimpleModule;
/**
 * User: Michael Williams
 * Date: 1/27/13
 * Time: 2:28 PM
 */
public class PartyCustomModule extends SimpleModule {

    public PartyCustomModule(String name, Version version) {
        super(name, version);
    }

    @Override
    public void setupModule(SetupContext context) {
        final SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(Name.class, NameData.class);
        resolver.addMapping(Person.class, PersonData.class);
        resolver.addMapping(Organization.class, OrganizationData.class);
        resolver.addMapping(Party.class, PartyData.class);
        context.addAbstractTypeResolver(resolver);
        super.setupModule(context);
    }

}

