package com.training.javaee.employee;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class EmployeeStorage {

    private final Map<String, Employee> employeeMap = new ConcurrentHashMap<>();

    public void insert(final Employee employeeParam) {
        this.employeeMap.put(employeeParam.getUsername(),
                             employeeParam);
    }

    public Employee get(final String userStringParam) {
        return this.employeeMap.get(userStringParam);
    }


}
