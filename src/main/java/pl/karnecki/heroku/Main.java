package pl.karnecki.heroku;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import pl.karnecki.MessageEndpoint;
import pl.karnecki.dao.MessageDao;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("");
        handler.addServlet(new ServletHolder(new ServletContainer(resourceConfig())), "/*");
        server.setHandler(handler);
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException("Could not start the server", e);
        }
    }

    private static ResourceConfig resourceConfig() throws URISyntaxException, SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        MessageDao messageDao = new MessageDao();
        messageDao.setDataSource(dataSourceProvider.getDataSource());
        MessageEndpoint messageEndpoint = new MessageEndpoint();
        messageEndpoint.setMessageDao(messageDao);
        return new ResourceConfig().register(messageEndpoint);
    }
}
