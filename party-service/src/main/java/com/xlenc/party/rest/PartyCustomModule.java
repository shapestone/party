package com.xlenc.party.rest;

import com.xlenc.party.*;
import org.codehaus.jackson.Version;

import org.codehaus.jackson.map.module.SimpleAbstractTypeResolver;
import org.codehaus.jackson.map.module.SimpleModule;
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
        resolver.addMapping(Name.class, NameImpl.class);
        resolver.addMapping(Person.class, PersonImpl.class);
        resolver.addMapping(Organization.class, OrganizationImpl.class);
        resolver.addMapping(Party.class, PartyImpl.class);
        context.addAbstractTypeResolver(resolver);
        super.setupModule(context);
    }

}

