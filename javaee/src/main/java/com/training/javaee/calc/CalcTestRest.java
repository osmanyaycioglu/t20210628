package com.training.javaee.calc;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.javaee.cdi.IProcess;

@Path("/v1/calc2")
@RequestScoped
//@SessionScoped
//@ApplicationScoped
public class CalcTestRest implements Serializable {

    private static final long serialVersionUID = 3967120849252482763L;

    private int               counter          = 0;

    @Inject
    @Named("dyn")
    private IProcess          dynProcess;

    @Path("/dyn")
    @GET
    public String dyn(@QueryParam("val1") final Integer val1,
                      @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.dynProcess.process(val1,
                                         val2)
               + " counter : "
               + this.counter++;
    }
}
