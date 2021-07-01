package com.training.javaee.employee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.jpa.EmployeeDao;

@LocalBean
@Singleton
public class EmployeeProvisionService {

    @EJB
    private EmployeeDao employeeDao;

    public boolean add(final Employee employeeParam) {
        //        Employee employeeLoc = this.employeeDao.get(employeeParam.getUsername());
        //        if (employeeLoc != null) {
        //            return false;
        //        }
        this.employeeDao.insert(employeeParam);
        return true;
    }

    //    public Employee get(final String usernameParam) {
    //        return this.employeeStorage.get(usernameParam);
    //    }

}
