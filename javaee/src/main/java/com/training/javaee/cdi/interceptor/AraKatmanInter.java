package com.training.javaee.cdi.interceptor;

import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@AraKatman
public class AraKatmanInter {

    @AroundInvoke
    public Object doIntercept(final InvocationContext ic) throws Throwable {
        Method methodLoc = ic.getMethod();
        CheckStr annotationLoc = methodLoc.getAnnotation(CheckStr.class);
        System.out.println("Before AraKatman Annotated method name : " + methodLoc.getName());
        Object[] parametersLoc = ic.getParameters();
        Object[] newParametersLoc = new Object[parametersLoc.length];
        for (int iLoc = 0; iLoc < parametersLoc.length; iLoc++) {
            if (parametersLoc[iLoc] instanceof String) {
                if (annotationLoc.value()
                                 .equals(parametersLoc[iLoc])) {
                    newParametersLoc[iLoc] = "veli";
                } else {
                    String stringLoc = (String) parametersLoc[iLoc] + " intercepted!.";
                    newParametersLoc[iLoc] = stringLoc;
                }
            } else {
                newParametersLoc[iLoc] = parametersLoc[iLoc];
            }
        }
        ic.setParameters(newParametersLoc);
        for (Object objectLoc : parametersLoc) {
            System.out.println("Param : " + objectLoc);
        }
        try {
            // return "Intercepted ...";
            Object proceedLoc = ic.proceed();
            if (proceedLoc instanceof String) {
                String resultStringLoc = (String) proceedLoc;
                return "Daha sonra ekledik " + resultStringLoc;
            }
            return ic.proceed();
        } catch (Throwable eLoc) {
            throw eLoc;
        }
    }

}
