package com.training.javaee.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/first/hello")
public class MyFirstRest {

    // @Path("/hello")
    @GET
    public String helloGet() {
        return "Hello world GET";
    }

    @Path("/alter")
    @GET
    public String helloAlt() {
        return "Hello world GET alt";
    }

    // @Path("/hello")
    @POST
    public String helloPost() {
        return "Hello world POST";
    }

    // @Path("/hello")
    @PUT
    public String helloPut() {
        return "Hello world PUT";
    }

    // @Path("/hello")
    @DELETE
    public String helloDelete() {
        return "Hello world DELETE";
    }

}
