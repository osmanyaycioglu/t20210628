package com.training.javaee.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v1/person/greetings")
public class PersonRest {

    @Path("/hello/{abc}/{efg}")
    @GET
    public String hello(@PathParam("abc") final String name,
                        @PathParam("efg") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/hello2")
    @GET
    public String hello2(@QueryParam("isim") final String name,
                         @QueryParam("soyisim") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @Path("/hello3/{xyz}")
    @GET
    public String hello3(@PathParam("xyz") final String name,
                         @QueryParam("soyisim") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @Path("/hello4")
    @GET
    public String hello4(@HeaderParam("isim") final String name,
                         @HeaderParam("soyisim") final String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @Path("/hello5")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON
    })
    public String hello5(final Person personParam) {
        return "Hello 5 " + personParam;
    }

    @Path("/hello6")
    @POST
    @Produces({
                MediaType.APPLICATION_JSON
    })
    @Consumes({
                MediaType.APPLICATION_JSON
    })
    public Person hello6(final Person personParam) {
        personParam.setHeight(300);
        return personParam;
    }

    @Path("/hello7")
    @POST
    public String hello7(@FormParam("isim") final String name,
                         @FormParam("soyisim") final String surname) {
        return "Hello 7 " + name + " " + surname;
    }

    @Path("/hello8/{he}/{we}")
    @GET
    public String hello8(@BeanParam final Person personParam) {
        return "Hello 8 " + personParam;
    }

}
