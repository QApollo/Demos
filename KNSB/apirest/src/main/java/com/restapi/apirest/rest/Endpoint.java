package com.restapi.apirest.rest;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//@ApplicationScoped
@Path("/content")
public class Endpoint {

    @Inject
    FileManager manager = new FileManager();
    @GET
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomer() {
        try {
            JSONObject json = manager.read();
            return Response.ok(json.toString()).status(200)
                    .build();
        } catch (IOException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DELETE
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCustomer(Customer customer) {
        try {
            manager.delete(Integer.parseInt(customer.getLocationInFile()));
        } catch (java.lang.NumberFormatException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (IOException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().status(200)
                .build();
    }

    @POST
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createCustomer(Customer customer) {
        if(!customer.getSurname().matches(".*[a-z].*")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        manager.create(customer.getSurname());

        return Response.ok().status(201)
                .build();
    }

    @PUT
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCustomer(Customer customer)  {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(customer.getSurname());

        if(!matcher.matches()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try {
            manager.update(Integer.parseInt(customer.getLocationInFile()),customer.getSurname());
        } catch (NumberFormatException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().status(200)
                .build();
    }

}


