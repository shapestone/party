package com.xlenc.party;

import com.google.code.morphia.annotations.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/17/11
 * Time: 5:03 PM
 */
@Entity("relationships")
public @Data class RelationshipImpl implements Relationship {

    @Id
    private String id;
    @Embedded
    private RelationshipType type;
    @Property("firstRolePartyId")
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private String firstRolePartyId;
    @Transient
    private Party firstRole;
    @Transient
    private Party secondRole;
    @Property("secondRolePartyId")
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private String secondRolePartyId;
    @Property("effectiveDate")
    private Date effectiveDate;
    @Property("untilDate")
    private Date untilDate;
    @Property("lastModifiedDate")
    private Date lastModifiedDate;
    @Property("createdDate")
    private Date createdDate;
    @Property("version")
    private Long version;

    public RelationshipImpl() {
    }

    public RelationshipImpl(String id) {
        this.id = id;
    }

    public RelationshipImpl(Party firstRole, Party secondRole, RelationshipType partyRelationshipType) {
        this.firstRole = firstRole;
        this.secondRole = secondRole;
        this.type = partyRelationshipType;
    }

    @PrePersist
    void prePersist() {
        if(firstRole != null) {
            firstRolePartyId = firstRole.getId();
        }
        if (secondRole != null) {
            secondRolePartyId = secondRole.getId();
        }
    }

    @PostLoad
    void postLoad() {
        this.firstRole = new PartyData(firstRolePartyId);
        this.secondRole = new PartyData(secondRolePartyId);
    }

}
