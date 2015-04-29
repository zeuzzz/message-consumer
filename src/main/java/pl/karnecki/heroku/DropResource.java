package pl.karnecki.heroku;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import pl.karnecki.MessageEndpoint;
import pl.karnecki.dao.MessageDao;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class DropResource extends ResourceConfig {

    public DropResource() throws URISyntaxException, SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        MessageDao messageDao = new MessageDao();
        messageDao.setDataSource(dataSourceProvider.getDataSource());
        MessageEndpoint messageEndpoint = new MessageEndpoint();
        messageEndpoint.setMessageDao(messageDao);

        register(messageEndpoint);
        register(MoxyJsonFeature.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
