package com.xlenc.party.rest;

import com.xlenc.party.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * User: Michael Williams
 * Date: 11/22/12
 * Time: 2:46 AM
 */
@Component
@Path("/parties")
public class PartyResource {

    @Autowired
    private PartyService partyService;

    @POST
    @Path("/party-type-options")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPartyTypeOption(PartyTypeOption partyTypeOption) {
        final PartyTypeOption addedPartyTypeOption = partyService.add(partyTypeOption);
        final Map<String, Object> map = singletonMap("id", (Object) addedPartyTypeOption.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/party-type-options/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPartyTypeOption(@PathParam("id") String id) {
        final PartyTypeOption readPartyType = partyService.read(new PartyTypeOption(id));
        final Response response;
        if (readPartyType == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readPartyType).build();
        }
        return response;
    }

    @DELETE
    @Path("/party-type-options/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePartyTypeOption(@PathParam("id") String id) {
        final int deleted = partyService.delete(new PartyTypeOption(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

    @POST
    @Path("/persons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        final Person addedPerson = partyService.add(person);
        final Map<String, Object> map = singletonMap("id", (Object) addedPerson.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/persons/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPerson(@PathParam("id") String id) {
        final Person readPerson = partyService.read(new PersonImpl(id));
        final Response response;
        if (readPerson == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readPerson).build();
        }
        return response;
    }

    @DELETE
    @Path("/persons/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") String id) {
        final int deleted = partyService.delete(new PersonImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

    @POST
    @Path("/organizations")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrganization(Organization organization) {
        final Organization newOrganization = partyService.add(organization);
        Map<String, Object> map = singletonMap("id", (Object) newOrganization.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/organizations/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readOrganization(@PathParam("id") String id) {
        final Organization newOrganization = partyService.read(new OrganizationImpl(id));
        final Response response;
        if (newOrganization == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(newOrganization).build();
        }
        return response;
    }

    @DELETE
    @Path("/organizations/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrganization(@PathParam("id") String id) {
        final int deleted = partyService.delete(new OrganizationImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

    @POST
    @Path("/relationship-type-options")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRelationshipTypeOption(RelationshipTypeOption relationshipTypeOption) {
        final RelationshipTypeOption addedRelationshipTypeOption = partyService.add(relationshipTypeOption);
        final Map<String, Object> map = singletonMap("id", (Object) addedRelationshipTypeOption.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/relationship-type-options/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readRelationshipTypeOption(@PathParam("id") String id) {
        final RelationshipTypeOption readRelationshipType = partyService.read(new RelationshipTypeOption(id));
        final Response response;
        if (readRelationshipType == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readRelationshipType).build();
        }
        return response;
    }

    @DELETE
    @Path("/relationship-type-options/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRelationshipTypeOption(@PathParam("id") String id) {
        final int deleted = partyService.delete(new RelationshipTypeOption(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

    @POST
    @Path("/relationships")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRelationship(Relationship partyRelationship) {
        final Relationship newPartyRelationship = partyService.add(partyRelationship);
        Map<String, Object> map = singletonMap("id", (Object) newPartyRelationship.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/relationships/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readRelationship(@PathParam("id") String id) {
        final Relationship newRelationship = partyService.read(new RelationshipImpl(id));
        final Response response;
        if (newRelationship == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(newRelationship).build();
        }
        return response;
    }

    @DELETE
    @Path("/relationships/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRelationship(@PathParam("id") String id) {
        final int deleted = partyService.delete(new RelationshipImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }


}
