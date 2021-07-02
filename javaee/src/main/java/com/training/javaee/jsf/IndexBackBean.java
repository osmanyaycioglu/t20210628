package com.training.javaee.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;


@Named("indexBean")
@SessionScoped
public class IndexBackBean implements Serializable {

    private static final long serialVersionUID = -5094433066075496523L;

    @Size(min = 2, max = 15)
    private String            str              = "osman";
    private String            choice;


    public String getStr() {
        return this.str;
    }

    public void setStr(final String strParam) {
        this.str = strParam;
    }

    public String process() {
        System.out.println("process çağrıldı");
        return "next";
    }

    public String getChoice() {
        return this.choice;
    }

    public void setChoice(final String choiceParam) {
        this.choice = choiceParam;
    }

}
