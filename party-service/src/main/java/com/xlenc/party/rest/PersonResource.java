package com.xlenc.party.rest;

import com.xlenc.party.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.Response.Status.*;

/**
 * User: Michael Williams
 * Date: 11/22/12
 * Time: 2:46 AM
 */
@Path("/parties/persons")
public class PersonResource {

    private PartyService partyService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(PersonImpl person) {
        final Person addedPerson = partyService.add(person);
        final Map<String, Object> map = singletonMap("id", (Object) addedPerson.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @POST
    @Path("/empty-person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson() {
        final Person addedPerson = partyService.addEmptyPerson();
        final Map<String, Object> map = singletonMap("id", (Object) addedPerson.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/{id}")
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
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") String id) {
        final int deleted = partyService.delete(new PersonImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

}
