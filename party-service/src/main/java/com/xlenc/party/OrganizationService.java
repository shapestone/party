package com.xlenc.party;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 4:56 PM
 */
public class OrganizationService {

    private OrganizationPersistence organizationPersistence;

    public OrganizationService(OrganizationPersistence organizationPersistence) {
        this.organizationPersistence = organizationPersistence;
    }

    public OrganizationData add(OrganizationData organizationData) {
        notNull(organizationData, "Parameter \"person\" cannot be null.");
        return organizationPersistence.saveParty(organizationData);
    }

    public OrganizationData addEmptyOrganization() {
        return organizationPersistence.saveParty(new OrganizationData());
    }

    public OrganizationData read(OrganizationData organizationData) {
        notNull(organizationData, "Parameter \"person\" cannot be null.");
        return organizationPersistence.findParty(organizationData);
    }

    public int delete(OrganizationData organizationData) {
        notNull(organizationData, "Parameter \"person\" cannot be null.");
        return organizationPersistence.deleteParty(organizationData);
    }

}
