package com.training.javaee.employee;

import java.util.Set;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/v1/employee/provision")
public class EmployeeRest {

    @EJB
    private EmployeeProvisionService employeeProvisionService;

    @Path("/add")
    @POST
    public String add(@Valid final Employee employeeParam) {
        //        if ((employeeParam.getUsername() == null)
        //            || employeeParam.getUsername()
        //                            .isEmpty()) {
        //            throw new IllegalArgumentException("username boş olamaz");
        //        }
        employeeParam.getEmployeeAddress()
                     .setEmployee(employeeParam);
        Set<EmployeePhone> employeePhonesLoc = employeeParam.getEmployeePhones();
        if (employeePhonesLoc != null) {
            for (EmployeePhone employeePhoneLoc : employeePhonesLoc) {
                employeePhoneLoc.setEmployee(employeeParam);
            }
        }
        boolean addLoc = this.employeeProvisionService.add(employeeParam);
        if (addLoc) {
            return "SUCCESS";
        } else {
            return "FAILED";
        }
    }

    @Path("/get/{username}")
    @GET
    public Employee get(@PathParam("username") final String username) {
        return null;
        //        return this.employeeProvisionService.get(username);
    }

}
