package com.training.javaee.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyValidationErrorHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exp) {
        ErrorObj errorObjLoc = new ErrorObj().setMsg("Validasyon hatası oluştu")
                                             .setErrorCause(800);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exp.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            errorObjLoc.addSubError(new ErrorObj().setMsg(constraintViolationLoc.getMessage())
                                                  .setErrorCause(807));
        }
        return Response.status(Status.BAD_REQUEST)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(errorObjLoc)
                       .build();
    }


}
