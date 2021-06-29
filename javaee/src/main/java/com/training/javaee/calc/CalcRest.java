package com.training.javaee.calc;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
