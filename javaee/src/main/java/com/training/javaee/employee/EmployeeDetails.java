package com.training.javaee.employee;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class EmployeeDetails {

    @Enumerated(EnumType.STRING)
    private EGender gender;
    private long    height;

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    public long getHeight() {
        return this.height;
    }

    public void setHeight(final long heightParam) {
        this.height = heightParam;
    }


}
