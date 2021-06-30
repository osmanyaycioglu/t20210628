package com.training.javaee.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         msg;
    private int            errorCause;


    public ErrorObj() {
    }

    public ErrorObj(final String msgParam,
                    final int errorCauseParam,
                    final List<ErrorObj> subErrorsParam) {
        super();
        this.subErrors = subErrorsParam;
        this.msg = msgParam;
        this.errorCause = errorCauseParam;
    }


    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public ErrorObj setMsg(final String msgParam) {
        this.msg = msgParam;
        return this;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public ErrorObj setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
        return this;
    }

    public static void main(final String[] args) {
        // 1
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setMsg("Error");
        errorObjLoc.setErrorCause(100);
        ErrorObj sube = new ErrorObj();
        sube.setMsg("Error");
        sube.setErrorCause(100);
        errorObjLoc.addSubError(sube);

        // 2
        List<ErrorObj> errorObjsLoc = new ArrayList<>();
        ErrorObj sube2 = new ErrorObj();
        sube2.setMsg("Error");
        sube2.setErrorCause(100);
        errorObjsLoc.add(sube2);
        ErrorObj err = new ErrorObj("Error",
                                    120,
                                    errorObjsLoc);

        //3
        ErrorObj err2 = new ErrorObj().setMsg("Error root")
                                      .setErrorCause(120)
                                      .addSubError(new ErrorObj().setMsg("level 1 a")
                                                                 .setErrorCause(101)
                                                                 .addSubError(new ErrorObj().setMsg("level 2 error a1")
                                                                                            .setErrorCause(103))
                                                                 .addSubError(new ErrorObj().setMsg("level 2 error a2")
                                                                                            .setErrorCause(103)))
                                      .addSubError(new ErrorObj().setMsg("level 1 b")
                                                                 .setErrorCause(102)
                                                                 .addSubError(new ErrorObj().setMsg("level 2 error b")
                                                                                            .setErrorCause(103)));

    }

}
