package dev.jetty_exemple;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Hello world!
 *
 */
public class MonJettyServer {
    public static void main( String[] args ) throws Exception{
       
    	//création du serveur
    	Server server = new Server();  
    	//création du port
    	ServerConnector connector = new ServerConnector(server); 
    	connector.setPort(8080);
    	server.setConnectors(new Connector[] {
    			connector
    	});
    	//This extension to the ContextHandler allows for simple construction 
    	//of a context with ServletHandler and optionally session and security handlers, etc. 
    	ServletContextHandler context = new ServletContextHandler(); 
    	
    	context.setContextPath("/monAppli");
    	
    	context.addServlet(HelloServlet.class, "/hello"); 
    	
    	HandlerCollection handlers = new HandlerCollection(); 
    	
    	handlers.setHandlers(new Handler[] {context, new DefaultHandler()});
    	server.setHandler(handlers);
    	
    	server.start();
    	server.join();
    	
    }
}
