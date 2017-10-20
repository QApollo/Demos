package com.restapi.apirest.rest;

import org.json.JSONException;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


@ApplicationScoped
@Path("/content")
public class Endpoint {

//    @POST
//    @Produces("text/plain")
//    public Response doGet() {
//        return Response.ok("Hello from WildFly Swarm!").status(200)
//                .build();
//    }

    @GET
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLine(Customer crud,
                                 @QueryParam("deviceName") String deviceName) throws IOException, JSONException {

        JSONObject json = FileManager.read(0);
        return Response.ok(json.toString()).status(200)
                .build();
    }

    @DELETE
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteLine(Customer crud,
                                 @QueryParam("deviceName") String deviceName) throws IOException {
        printConsole(crud, deviceName);
        String message = "";
        FileManager.delete(Integer.parseInt(crud.getSurname()));

        return Response.ok(message).status(200)
                .build();
    }

    @POST
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createLine(Customer crud,
                                                 @QueryParam("deviceName") String deviceName) throws IOException {
        printConsole(crud, deviceName);
        System.out.println("this is: " + crud.getAction());
        String message = "";
        FileManager.create(crud.getSurname());

        return Response.ok(message).status(200)
                .build();
    }

    @PUT
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateLine(Customer crud,
                                 @QueryParam("deviceName") String deviceName) throws IOException {
        printConsole(crud, deviceName);
        System.out.println("I am now in UPDATE");
        String message = "";
        FileManager.update(Integer.parseInt(crud.getSurname()),crud.getMessage());
//        Response.status(Response.Status.NOT_FOUND);
        return Response.ok(message).status(200)
                .build();
    }

    private void printConsole(Customer customer, @QueryParam("deviceName") String deviceName) {
        System.out.println(deviceName);
        System.out.println(customer.getAction());
        System.out.println(customer.getSurname());
    }

}


