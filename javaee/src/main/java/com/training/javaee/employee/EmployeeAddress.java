package com.training.javaee.employee;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class EmployeeAddress {

    @Id
    @GeneratedValue
    @XmlTransient
    @JsonbTransient
    private Long     empAddId;

    private String   city;
    private String   street;

    @OneToOne
    @XmlTransient
    @JsonbTransient
    private Employee employee;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }

    public Long getEmpAddId() {
        return this.empAddId;
    }

    public void setEmpAddId(final Long empAddIdParam) {
        this.empAddId = empAddIdParam;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employeeParam) {
        this.employee = employeeParam;
    }


}
