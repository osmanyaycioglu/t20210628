package com.training.javaee.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyIllegalArgumentErrorHandler implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(final IllegalArgumentException exp) {
        exp.printStackTrace();
        return Response.status(Status.BAD_REQUEST)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(new ErrorObj().setMsg(exp.getMessage())
                                             .setErrorCause(400))
                       .build();
    }


}
