package com.prijilevschi.util;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class JettyServer {
	private static final Logger log = Logger.getLogger(JettyServer.class);
	
	private static final int DEFAULT_PORT = 8080;
	private static final String CONTEXT_PATH = "/";
	/** CONFIG_LOCATION points to the package where @Configuration classes are located **/
    private static final String CONFIG_LOCATION = "com.prijilevschi.config";
    private static final String MAPPING_URL = "/*";
    private static final String DEFAULT_PROFILE = "dev";
	
	private final int port;
	
	private Server server;
	
	public static void main(String[] args) throws Exception{
		JettyServer jetty = new JettyServer(DEFAULT_PORT);
		jetty.start();
		jetty.join();
	}
	
	public JettyServer(int port){
		this.port = port;
		
	}
	
	
	public void start() throws Exception{
		server = new Server(port);
		server.setHandler(getServletContextHandler(getContext()));
		
		try{
			server.start();
		}
		catch(Exception e){
			log.error("Failed to start server", e);
			throw new RuntimeException();
		}
		log.info("Server started");
	}
	
	 private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        contextHandler.setResourceBase(new ClassPathResource("webapp").getURI().toString());
        return contextHandler;
    }

    private static WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.getEnvironment().setDefaultProfiles(DEFAULT_PROFILE);
        return context;
    }
    
    public void join() throws InterruptedException{
		server.join();
	}
}
