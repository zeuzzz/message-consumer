package pl.karnecki.heroku;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;


public class DataSourceProvider {
    public DataSource getDataSource() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String userInfo = dbUri.getUserInfo();
        String username = userInfo.split(":")[0];
        String password = userInfo.split(":")[1];
        int port = dbUri.getPort();

        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

        DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, username, password);
        dataSource.setDriverClassName("org.postgresql.ds.PGPoolingDataSource");

        return dataSource;
    }
}
