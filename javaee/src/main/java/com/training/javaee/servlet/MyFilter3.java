package com.training.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebFilter(urlPatterns = {
                           "/tservlet"
})
public class MyFilter3 implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        String parameterLoc = requestParam.getParameter("xyz");
        if ("fail3".equalsIgnoreCase(parameterLoc)) {
            PrintWriter writerLoc = responseParam.getWriter();
            writerLoc.println("FAILED Filter3");
            HttpServletResponse httpServletResponseLoc = (HttpServletResponse) responseParam;
            httpServletResponseLoc.addHeader("Content-Type",
                                             MediaType.TEXT_PLAIN);
        } else {
            chainParam.doFilter(requestParam,
                                responseParam);
        }
    }

}
