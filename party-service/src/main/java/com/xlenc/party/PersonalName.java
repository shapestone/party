package com.xlenc.party;

import com.google.code.morphia.annotations.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * User: Michael Williams
 * Date: 11/9/13
 * Time: 10:46 AM
 */
@NoArgsConstructor
@AllArgsConstructor
public @Data class PersonalName {
    @Property("context")
    private String context;
    @Property("names")
    private List<Name> names;
}
