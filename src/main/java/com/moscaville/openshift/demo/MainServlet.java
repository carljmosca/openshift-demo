/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.openshift.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author moscac
 */
public class MainServlet extends HttpServlet {

    public static final String OPENSHIFT_DEMO = "OPENSHIFT_DEMO";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(MediaType.TEXT_HTML);
        try {
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<h1>Hello world from the main servlet.</h1>");
                if (System.getenv(OPENSHIFT_DEMO) != null) {
                    writer.println(OPENSHIFT_DEMO + " envirnment variable value: " + System.getenv(OPENSHIFT_DEMO));
                } else {
                    writer.println("No value found for " + OPENSHIFT_DEMO + " environment variable");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
