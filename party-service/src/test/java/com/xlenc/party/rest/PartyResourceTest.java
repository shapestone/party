package com.xlenc.party.rest;

import com.xlenc.party.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.Map;

import static javax.ws.rs.core.Response.Status.CREATED;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 12:33 PM
 */
public class PartyResourceTest extends BaseUnitTest {

    private PartyPersistence partyPersistence = mock(PartyPersistence.class);
    private PartyServiceImpl partyService = new PartyServiceImpl(partyPersistence);

    private OrganizationPersistence organizationPersistence = mock(OrganizationPersistence.class);
    private OrganizationService organizationService = new OrganizationService(organizationPersistence);
    private OrganizationResource organizationResource = new OrganizationResource(organizationService);


    @BeforeClass
    public void setUp() {
        final PartyServiceImpl partyService = new PartyServiceImpl(partyPersistence);
        this.partyPersistence = mock(PartyPersistence.class);
        setPrivateField(partyService, "partyPersistence", this.partyPersistence);
//        setPrivateField(partyResource, "partyService", partyService);
    }

    @Test(enabled = false)
    public void testAddOrganization() {
        final Organization organization = new OrganizationData();

        organization.setName("MFW Apparel");
        organization.setType(new PartyTypeImpl("Organization"));
//        when(partyPersistence.saveParty(organization)).thenReturn(new OrganizationData("10"));
//        final Response response = partyResource.addOrganization(organization);
//        @SuppressWarnings("unchecked")
//        final Map<String, Object> map = (Map<String, Object>)response.getEntity() ;
//        final Object id = map.get("id");
//        assertNotNull(id);
    }

    @Test(enabled = false)
    public void testAddPersonWithFirstName() {

        final Person person = new PersonData();
        final Name firstName = new NameData("firstName", "Michael");
        final Name middleName = new NameData("middleName", "Frederick");
        final Name lastName = new NameData("lastName", "Williams");

//        person.setNames( new Name[]{ firstName, middleName, lastName});
//        person.setType(new PartyTypeImpl("Person"));
//        when(partyPersistence.saveParty(person)).thenReturn(new PersonData("10"));
//        final Response response = partyResource.addPerson(person);
//        final int status = response.getStatus();
//        assertEquals(CREATED.getStatusCode(), status);
//        @SuppressWarnings("unchecked")
//        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
//        assertNotNull(entity);
//        notEmpty(entity);
//        final Object id = entity.get("id");
//        assertNotNull(id);

    }

    @Test(enabled = false)
    public void testAddPersonWithFirstLastName() {

        final Person person = new PersonData();
        final Name firstName = new NameData("firstName", "Michael");
        final Name lastName = new NameData("lastName", "Williams");

//        person.setNames(new Name[]{firstName, lastName});
//        person.setType(new PartyTypeImpl("Person"));
//        when(partyPersistence.saveParty(person)).thenReturn(new PersonData("10"));
//        final Response response = partyResource.addPerson(person);
//        final int status = response.getStatus();
//        assertEquals(CREATED.getStatusCode(), status);
//        @SuppressWarnings("unchecked")
//        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
//        assertNotNull(entity);
//        notEmpty(entity);
//        final Object id = entity.get("id");
//        assertNotNull(id);
    }

    @Test(enabled = false)
    public void testAddPersonWithFirstMiddleLastName() {

        final Person person = new PersonData();
        final Name firstName = new NameData("firstName", "Michael");
        final Name middleName = new NameData("middleName", "Frederick");
        final Name lastName = new NameData("lastName", "Williams");

//        person.setNames(new Name[]{firstName, middleName, lastName});
//        person.setType(new PartyTypeImpl("Person"));
//        when(partyPersistence.saveParty(person)).thenReturn(new PersonData("10"));
//        final Response response = partyResource.addPerson(person);
//        final int status = response.getStatus();
//        assertEquals(CREATED.getStatusCode(), status);
//        @SuppressWarnings("unchecked")
//        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
//        assertNotNull(entity);
//        notEmpty(entity);
//        final Object id = entity.get("id");
//        assertNotNull(id);
    }

    @Test(enabled = false)
    public void testAddPersonWithFirstMiddleLastDOBName() {

        final Person person = new PersonData();
        final Name firstName = new NameData("firstName", "Michael");
        final Name middleName = new NameData("middleName", "Frederick");
        final Name lastName = new NameData("lastName", "Williams");

//        person.setNames(new Name[]{firstName, middleName, lastName});
//        person.setDateOfBirth(new Date());
//        person.setType(new PartyTypeImpl("Person"));
//        when(partyPersistence.saveParty(person)).thenReturn(new PersonData("10"));
//        final Response response = partyResource.addPerson(person);
//        final int status = response.getStatus();
//        assertEquals(CREATED.getStatusCode(), status);
//        @SuppressWarnings("unchecked")
//        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
//        assertNotNull(entity);
        // notEmpty(entity);
//        final Object id = entity.get("id");
//        assertNotNull(id);
    }

}
