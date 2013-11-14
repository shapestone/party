package com.xlenc.party.rest;

import com.xlenc.party.*;
import com.xlenc.party.Organization;
import com.xlenc.party.api.*;

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
@Path("/parties/organizations")
public class OrganizationResource {

    private OrganizationService organizationService;

    public OrganizationResource(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrganization(OrganizationData organization) {
        final Organization newOrganization = organizationService.add(organization);
        Map<String, Object> map = singletonMap("id", (Object) newOrganization.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readOrganization(@PathParam("id") String id) {
        final Organization newOrganization = organizationService.read(new OrganizationData(id));
        final Response response;
        if (newOrganization == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(newOrganization).build();
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrganization(@PathParam("id") String id) {
        final int deleted = organizationService.delete(new OrganizationData(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

}
