package pl.karnecki.heroku;

public class Main {

//    public static void main(String[] args) throws Exception {
//        Server server = new Server(8081);
//        ServletContextHandler handler = new ServletContextHandler();
//        handler.setContextPath("");
//        handler.addServlet(new ServletHolder(new ServletContainer(resourceConfig())), "/*");
//        server.setHandler(handler);
//        try {
//            server.start();
//        } catch (Exception e) {
//            throw new RuntimeException("Could not start the server", e);
//        }
//    }
//
//    private static ResourceConfig resourceConfig() throws URISyntaxException, SQLException {
//        DataSourceProvider dataSourceProvider = new DataSourceProvider();
//        MessageDao messageDao = new MessageDao();
//        messageDao.setDataSource(dataSourceProvider.getDataSource());
//        MessageEndpoint messageEndpoint = new MessageEndpoint();
//        messageEndpoint.setMessageDao(messageDao);
//        ResourceConfig resourceConfig = new ResourceConfig();
//        resourceConfig.register(MoxyJsonFeature.class);
//        resourceConfig.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
//
//        return resourceConfig.register(messageEndpoint);
//    }
}
