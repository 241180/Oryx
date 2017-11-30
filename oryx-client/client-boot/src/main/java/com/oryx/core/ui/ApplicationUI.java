package com.oryx.core.ui;

import com.oryx.core.frame.ApplicationFrame;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

public class ApplicationUI {
    /*@WebServlet(urlPatterns = "/person/*")
    @VaadinServletConfiguration(ui = PersonFrame.class, productionMode = false)
    public static class PersonServlet extends VaadinServlet {
    }*/

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = ApplicationFrame.class, productionMode = false)
    public static class Servlet extends VaadinServlet {
    }
}
