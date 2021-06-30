package com.training.javaee.calc;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.javaee.cdi.IProcess;
import com.training.javaee.cdi.MultiplyBean;
import com.training.javaee.ejb.MySingletonBean;
import com.training.javaee.ejb.MyStatefulBean;
import com.training.javaee.ejb.MyStatelessBean;

@Path("/v1/calc")
@RequestScoped
//@SessionScoped
//@ApplicationScoped
public class CalcRest implements Serializable {

    private static final long serialVersionUID = -7767332677778592849L;

    @EJB
    private MyStatelessBean   myStatelessBean;

    @EJB
    private MyStatefulBean    myStatefulBean;

    @EJB
    private MySingletonBean   mySingletonBean;

    @Inject
    @Named("add")
    private IProcess          process;

    @Inject
    @Named("subs")
    private IProcess          subsProcess;

    @Inject
    @Alternative
    private IProcess          external;

    @Inject
    @MultiplyBean
    private IProcess          multiply;


    @Inject
    @Named("dyn")
    private IProcess dynProcess;

    @Inject
    @Named("dyn2")
    private IProcess dyn2Process;

    @Path("/dyn")
    @GET
    public String dyn(@QueryParam("val1") final Integer val1,
                      @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.dynProcess.process(val1,
                                         val2);
    }

    @Path("/dyn2")
    @GET
    public String dyn2(@QueryParam("val1") final Integer val1,
                       @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.dyn2Process.process(val1,
                                          val2);
    }

    @Path("/mul")
    @GET
    public String mul(@QueryParam("val1") final Integer val1,
                      @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.multiply.process(val1,
                                       val2);
    }

    @Path("/ext")
    @GET
    public String ext(@QueryParam("val1") final Integer val1,
                      @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.external.process(val1,
                                       val2);
    }

    @Path("/subs")
    @GET
    public String subs(@QueryParam("val1") final Integer val1,
                       @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.subsProcess.process(val1,
                                          val2);
    }

    @Path("/add2")
    @GET
    public String add2(@QueryParam("val1") final Integer val1,
                       @QueryParam("val2") final Integer val2) {
        return "Sonuç : "
               + this.process.process(val1,
                                      val2);
    }

    @Path("/add")
    @GET
    public String add(@QueryParam("val1") final Integer val1,
                      @QueryParam("val2") final Integer val2) {
        int addLoc = this.myStatelessBean.add(val1,
                                              val2);
        int totalLoc = this.myStatefulBean.getTotal();
        return "Sonuç : " + addLoc + " total : " + totalLoc;
    }

    @Path("/addstateful")
    @GET
    public String addstateful(@QueryParam("val1") final Integer val1,
                              @QueryParam("val2") final Integer val2) {
        int addLoc = this.myStatefulBean.add(val1,
                                             val2);
        int totalLoc = this.myStatefulBean.getTotal();
        if (totalLoc > 30) {
            this.myStatefulBean.xyz();
        }

        return "Sonuç : " + addLoc + " total : " + totalLoc;
    }

    @Path("/addsingleton")
    @GET
    public String addsingleton(@QueryParam("val1") final Integer val1,
                               @QueryParam("val2") final Integer val2) {
        int addLoc = this.mySingletonBean.add(val1,
                                              val2);
        int totalLoc = this.mySingletonBean.getTotal();
        return "Sonuç : " + addLoc + " total : " + totalLoc;
    }

}
