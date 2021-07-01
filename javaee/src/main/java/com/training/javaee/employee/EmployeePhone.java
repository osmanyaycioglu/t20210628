package com.training.javaee.employee;

import java.util.Objects;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class EmployeePhone {

    @Id
    @GeneratedValue
    @JsonbTransient
    @XmlTransient
    private Long     empPhoneId;
    private String   name;
    private String   number;

    @ManyToOne
    @JsonbTransient
    @XmlTransient
    private Employee employee;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name,
                            this.number);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        EmployeePhone other = (EmployeePhone) obj;
        return Objects.equals(this.name,
                              other.name)
               && Objects.equals(this.number,
                                 other.number);
    }

    public Long getEmpPhoneId() {
        return this.empPhoneId;
    }

    public void setEmpPhoneId(final Long empPhoneIdParam) {
        this.empPhoneId = empPhoneIdParam;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employeeParam) {
        this.employee = employeeParam;
    }


}
