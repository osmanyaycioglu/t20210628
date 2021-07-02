package com.training.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.training.javaee.employee.Employee;
import com.training.javaee.employee.EmployeePhone;
import com.training.javaee.employee.EmployeeProvisionService;

@WebServlet({
              "/tservlet"
})
public class MyServlet extends HttpServlet {

    private static final long        serialVersionUID = -4572218978240035223L;

    @EJB
    private EmployeeProvisionService employeeProvisionService;

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        String isimLoc = reqParam.getParameter("isim");
        String soyLoc = reqParam.getParameter("soyisim");

        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println("Hello : " + isimLoc + " " + soyLoc);
        respParam.addHeader("Content-Type",
                            MediaType.TEXT_PLAIN);
    }

    @Override
    protected void doPost(final HttpServletRequest reqParam,
                          final HttpServletResponse respParam) throws ServletException, IOException {
        char[] chars = new char[2048];
        int readLoc = reqParam.getReader()
                              .read(chars);
        String stringLoc = new String(chars,
                                      0,
                                      readLoc);
        Jsonb jsonb = JsonbBuilder.create();
        Employee employeeParam = jsonb.fromJson(stringLoc,
                                                Employee.class);
        employeeParam.getEmployeeAddress()
                     .setEmployee(employeeParam);
        Set<EmployeePhone> employeePhonesLoc = employeeParam.getEmployeePhones();
        if (employeePhonesLoc != null) {
            for (EmployeePhone employeePhoneLoc : employeePhonesLoc) {
                employeePhoneLoc.setEmployee(employeeParam);
            }
        }
        boolean addLoc = this.employeeProvisionService.add(employeeParam);
        String result = "FAILED";
        if (addLoc) {
            result = "SUCCESS";
        }
        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println(result);
        respParam.addHeader("Content-Type",
                            MediaType.TEXT_PLAIN);

    }
}
