package com.training.javaee.employee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class EmployeeProvisionService {

    @EJB
    private EmployeeStorage employeeStorage;

    public boolean add(final Employee employeeParam) {
        Employee employeeLoc = this.employeeStorage.get(employeeParam.getUsername());
        if (employeeLoc != null) {
            return false;
        }
        this.employeeStorage.insert(employeeParam);
        return true;
    }

    public Employee get(final String usernameParam) {
        return this.employeeStorage.get(usernameParam);
    }

}
