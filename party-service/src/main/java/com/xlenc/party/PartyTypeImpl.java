package com.xlenc.party;

import com.google.code.morphia.annotations.Property;
import lombok.Data;

/**
 * Date: 1/23/11
 * Time: 3:48 PM
 */
public @Data class PartyTypeImpl implements PartyType {
    @Property("name")
    private String name;

    public PartyTypeImpl(String name) {
        this.name = name;
    }
}
