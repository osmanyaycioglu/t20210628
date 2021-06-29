package com.training.javaee.employee;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Employee {

    @NotEmpty(message = "username boş olamaz")
    @Size(min = 5, max = 15, message = "username 5 ile 15 arasında olmalı")
    private String username;
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String name;
    @NotNull
    private String surname;
    private String department;
    @Positive
    @Max(300)
    @Min(10)
    private int    weight;

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


}
