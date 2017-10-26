package com.restapi.apirest.rest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(Customer customer,
                                 @QueryParam("deviceName") String deviceName) throws IOException, JSONException {

        JSONObject json = manager.read();
        return Response.ok(json.toString()).status(200)
                .build();
    }

    @DELETE
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCustomer(Customer customer,
                                 @QueryParam("deviceName") String deviceName) throws IOException {
//        printConsole(customer, deviceName);
        System.out.println("I am in delete");
//        String message = "";
        try{
            manager.delete(Integer.parseInt(customer.getLine()));
        }catch (java.lang.NumberFormatException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok("").status(200)
                .build();
    }

    @POST
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createCustomer(Customer customer,
                                                 @QueryParam("deviceName") String deviceName) throws IOException {
//        printConsole(customer, deviceName);
        if(!customer.getSurname().matches(".*[a-z].*")){
            System.out.println("wrong");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        manager.create(customer.getSurname());

        return Response.ok("").status(200)
                .build();
    }

    @PUT
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCustomer(Customer customer,
                                 @QueryParam("deviceName") String deviceName) throws IOException {
//        printConsole(customer, deviceName);
        System.out.println("I am now in UPDATE");
//        String message = "";
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(customer.getSurname());

        if(!matcher.matches()){
            System.out.println("wrong");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        try{
            manager.update(Integer.parseInt(customer.getLine()),customer.getSurname());
        }catch (NumberFormatException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

//        Response.status(Response.Status.NOT_FOUND);
        return Response.ok("").status(200)
                .build();
    }

    private void printConsole(Customer customer, @QueryParam("deviceName") String deviceName) {
        System.out.println(deviceName);
        System.out.println(customer.getAction());
        System.out.println("surname is: "+customer.getSurname());
    }

}


