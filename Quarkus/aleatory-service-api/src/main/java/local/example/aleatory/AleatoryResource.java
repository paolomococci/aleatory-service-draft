package local.example.aleatory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aleatory")
public class AleatoryResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String aleatory() {
        return "0";
    }
}
