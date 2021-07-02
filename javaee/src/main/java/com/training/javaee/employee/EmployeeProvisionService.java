package com.training.javaee.employee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.Transactional;

import com.training.javaee.jpa.EmployeeDao;

@LocalBean
@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmployeeProvisionService {

    @EJB
    private EmployeeDao employeeDao;

    @Transactional
    public boolean add(final Employee employeeParam) {
        //        Employee employeeLoc = this.employeeDao.get(employeeParam.getUsername());
        //        if (employeeLoc != null) {
        //            return false;
        //        }
        this.employeeDao.insert(employeeParam);
        //        this.employeeDao.insert2(employeeParam);
        //        this.employeeDao.insert3(employeeParam);
        return true;
    }

    //    public Employee get(final String usernameParam) {
    //        return this.employeeStorage.get(usernameParam);
    //    }

}
