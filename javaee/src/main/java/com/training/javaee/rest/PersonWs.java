package com.training.javaee.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://training.turkcell.com")
public class PersonWs {

    public String hello(@WebParam(name = "name") final String name,
                        @WebParam(name = "surname") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @WebResult(name = "personResult")
    public Person hello6(@WebParam(name = "person") final Person personParam) {
        personParam.setHeight(300);
        return personParam;
    }


    @WebMethod(exclude = true)
    public void test() {

    }

}
