package com.xlenc.party;

/**
 * User: Michael Williams
 * Date: 5/4/13
 * Time: 1:43 PM
 */
public interface Organization extends Party {

    String getName();

    String getPurpose();

    void setName(String name);

    void setPurpose(String purpose);
}
