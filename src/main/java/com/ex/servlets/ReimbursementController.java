package com.ex.servlets;

import com.ex.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class ReimbursementController extends HttpServlet {
    // setup the servlet with the context
    // or create new instances of the supporting objects


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // retrieve all reimbursements
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter()
                .write(
                        new ObjectMapper()
                            .writeValueAsString(
                                    new ArrayList(
                                            Arrays.asList(new Reimbursement(1,new BigDecimal(200),123,222, "Approved"))
                                    )));
    }
}

