package com.training.javaee.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/v1/person/management")
public class PersonManagementRest {

    @PUT
    public String add() {
        return "SUCCESS";
    }

    @DELETE
    public String delete() {
        return "SUCCESS";
    }

    @PATCH
    public String patch() {
        return "SUCCESS";
    }

    // Cohesion
}
