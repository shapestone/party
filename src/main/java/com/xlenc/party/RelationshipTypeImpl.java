package com.xlenc.party;

import com.google.code.morphia.annotations.Property;
import lombok.Data;

/**
 * User: Michael Williams
 * Date: 1/23/11
 * Time: 3:48 PM
 */
public @Data class RelationshipTypeImpl implements RelationshipType {

    @Property("name")
    private String name;

    public RelationshipTypeImpl() {
    }

    public RelationshipTypeImpl(String name) {
        this.name = name;
    }

}
