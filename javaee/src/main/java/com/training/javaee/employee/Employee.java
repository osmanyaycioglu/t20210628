package com.training.javaee.employee;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.training.javaee.employee.custom.validation.StartWith;

@NamedQueries({
                @NamedQuery(query = "select e from Employee e where e.name=?1", name = "employee_find_by_id")
})
@NamedNativeQueries({
                      @NamedNativeQuery(query = "select * from Employee e where e.name=?1",
                                        name = "native_employee_find_by_id")
})
@Entity
@Table(name = "emp_table")
public class Employee {

    @Id
    @GeneratedValue
    private Long               empId;
    @NotEmpty(message = "username boş olamaz")
    @Size(min = 5, max = 15, message = "username 5 ile 15 arasında olmalı")
    private String             username;
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    @Column(name = "isim")
    private String             name;
    @StartWith("sur:")
    @NotNull
    @Size(min = 2, max = 50, message = "surname 2 ile 50 arasında olmalı")
    @Column(length = 50)
    private String             surname;
    @StartWith("dep:")
    private String             department;
    @Positive
    @Max(300)
    @Min(10)
    private int                weight;

    private Long               updateDate;

    @Embedded
    private EmployeeDetails    employeeDetails;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private EmployeeAddress    employeeAddress;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<EmployeePhone> employeePhones;

    //    @Version
    //    private Integer            version;

    @PrePersist
    public void prePer() {
        this.username = "usr:" + this.username;
        this.updateDate = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUp() {
        this.username = "usr:" + this.username;
        this.updateDate = System.currentTimeMillis();
    }

    @PreRemove
    public void preRem() {
        System.out.println("Entity siliniyor.");
    }

    @PostPersist
    @PostUpdate
    public void postPer() {
        this.username = this.username.substring(4);
    }

    //    @PostUpdate
    //    public void postUp() {
    //        this.username = this.username.substring(4);
    //    }

    @PostRemove
    public void postRem() {
        System.out.println("Entity silindi.");
    }

    @PostLoad
    public void postLoad() {
        this.username = this.username.substring(4);
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(final String departmentParam) {
        this.department = departmentParam;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weightParam) {
        this.weight = weightParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public EmployeeDetails getEmployeeDetails() {
        return this.employeeDetails;
    }

    public void setEmployeeDetails(final EmployeeDetails employeeDetailsParam) {
        this.employeeDetails = employeeDetailsParam;
    }

    public EmployeeAddress getEmployeeAddress() {
        return this.employeeAddress;
    }

    public void setEmployeeAddress(final EmployeeAddress employeeAddressParam) {
        this.employeeAddress = employeeAddressParam;
    }

    public Set<EmployeePhone> getEmployeePhones() {
        return this.employeePhones;
    }

    public void setEmployeePhones(final Set<EmployeePhone> employeePhonesParam) {
        this.employeePhones = employeePhonesParam;
    }

    public Long getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(final Long updateDateParam) {
        this.updateDate = updateDateParam;
    }


}
