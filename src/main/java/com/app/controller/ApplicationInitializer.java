package com.app.controller;

import com.app.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    private final static String DISPATCHER = "dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(webApplicationContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
