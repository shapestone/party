package com.xlenc.party;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: Michael Williams
 * Date: 1/6/13
 * Time: 3:40 PM
 */
@NoArgsConstructor
@AllArgsConstructor
public @Data class NameData implements Name {
    private String type;
    private String text;
    private int ordinal;

    public NameData(String type, String text) {
        this.type = type;
        this.text = text;
    }
}
