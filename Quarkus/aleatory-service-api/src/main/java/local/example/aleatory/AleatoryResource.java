package local.example.aleatory;

import io.quarkus.vertx.web.Route;

import javax.ws.rs.core.MediaType;

public class AleatoryResource {

    @Route(
            produces = MediaType.TEXT_PLAIN,
            methods = Route.HttpMethod.GET,
            path = "/aleatory"
    )
    public String aleatory() {
        return "0";
    }
}
