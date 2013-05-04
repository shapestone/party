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
import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;
import static org.testng.Assert.assertEquals;

/**
 * User: Michael Williams
 * Date: 11/25/12
 * Time: 12:33 PM
 */
public class PartyResourceTest extends BaseUnitTest {

    private PartyResource partyResource = new PartyResource();
    private PartyPersistence partyPersistence = mock(PartyPersistence.class);

    @BeforeClass
    public void setUp() {
        final PartyServiceImpl partyService = new PartyServiceImpl();
        this.partyPersistence = mock(PartyPersistence.class);
        setPrivateField(partyService, "partyPersistence", this.partyPersistence);
        setPrivateField(partyResource, "partyService", partyService);
    }

    @Test
    public void testAddOrganization() {
        final Organization organization = new OrganizationImpl();

        organization.setName("MFW Apparel");
        organization.setType(new PartyTypeImpl("Organization"));
        when(partyPersistence.add(organization)).thenReturn(new OrganizationImpl("10"));
        final Response response = partyResource.addOrganization(organization);
        @SuppressWarnings("unchecked")
        final Map<String, Object> map = (Map<String, Object>)response.getEntity() ;
        final Object id = map.get("id");
        notNull(id);
    }

    @Test
    public void testAddPersonWithFirstName() {

        final Person person = new PersonImpl();
        final Name firstName = new NameImpl("firstName", "Michael");
        final Name middleName = new NameImpl("middleName", "Frederick");
        final Name lastName = new NameImpl("lastName", "Williams");

        person.setNames( new Name[]{ firstName, middleName, lastName});
        person.setType(new PartyTypeImpl("Person"));
        when(partyPersistence.add(person)).thenReturn(new PersonImpl("10"));
        final Response response = partyResource.addPerson(person);
        final int status = response.getStatus();
        assertEquals(CREATED.getStatusCode(), status);
        @SuppressWarnings("unchecked")
        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
        notNull(entity);
        notEmpty(entity);
        final Object id = entity.get("id");
        notNull(id);

    }

    @Test
    public void testAddPersonWithFirstLastName() {

        final Person person = new PersonImpl();
        final Name firstName = new NameImpl("firstName", "Michael");
        final Name lastName = new NameImpl("lastName", "Williams");

        person.setNames(new Name[]{firstName, lastName});
        person.setType(new PartyTypeImpl("Person"));
        when(partyPersistence.add(person)).thenReturn(new PersonImpl("10"));
        final Response response = partyResource.addPerson(person);
        final int status = response.getStatus();
        assertEquals(CREATED.getStatusCode(), status);
        @SuppressWarnings("unchecked")
        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
        notNull(entity);
        notEmpty(entity);
        final Object id = entity.get("id");
        notNull(id);
    }

    @Test
    public void testAddPersonWithFirstMiddleLastName() {

        final Person person = new PersonImpl();
        final Name firstName = new NameImpl("firstName", "Michael");
        final Name middleName = new NameImpl("middleName", "Frederick");
        final Name lastName = new NameImpl("lastName", "Williams");

        person.setNames(new Name[]{firstName, middleName, lastName});
        person.setType(new PartyTypeImpl("Person"));
        when(partyPersistence.add(person)).thenReturn(new PersonImpl("10"));
        final Response response = partyResource.addPerson(person);
        final int status = response.getStatus();
        assertEquals(CREATED.getStatusCode(), status);
        @SuppressWarnings("unchecked")
        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
        notNull(entity);
        notEmpty(entity);
        final Object id = entity.get("id");
        notNull(id);
    }

    @Test
    public void testAddPersonWithFirstMiddleLastDOBName() {

        final Person person = new PersonImpl();
        final Name firstName = new NameImpl("firstName", "Michael");
        final Name middleName = new NameImpl("middleName", "Frederick");
        final Name lastName = new NameImpl("lastName", "Williams");

        person.setNames(new Name[]{firstName, middleName, lastName});
        person.setDateOfBirth(new Date());
        person.setType(new PartyTypeImpl("Person"));
        when(partyPersistence.add(person)).thenReturn(new PersonImpl("10"));
        final Response response = partyResource.addPerson(person);
        final int status = response.getStatus();
        assertEquals(CREATED.getStatusCode(), status);
        @SuppressWarnings("unchecked")
        final Map<String, Object>  entity = (Map<String, Object>)response.getEntity();
        notNull(entity);
        notEmpty(entity);
        final Object id = entity.get("id");
        notNull(id);
    }

    @Test
    public void testAddPartyRelationship() {
        final Person person = new PersonImpl("1");
        final Organization organization = new OrganizationImpl("1");
        final RelationshipType relationshipType = new RelationshipTypeImpl("Employment");
        final Relationship relationship = new RelationshipImpl(person, organization, relationshipType);

        when(partyPersistence.add(relationship)).thenReturn(new RelationshipImpl("1"));
        final Response response = partyResource.addRelationship(relationship);
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>)response.getEntity();
        final Object id = map.get("id");
        notNull(id);
    }

}
