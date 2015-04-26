package pl.karnecki;

import lombok.Setter;
import pl.karnecki.dao.MessageDao;
import pl.karnecki.model.Message;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/")
@Setter
public class MessageEndpoint {

    private MessageDao messageDao;

    @POST
    @Path("message")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public void handleMessage(Message message) {
        messageDao.insert(message);
    }
}
