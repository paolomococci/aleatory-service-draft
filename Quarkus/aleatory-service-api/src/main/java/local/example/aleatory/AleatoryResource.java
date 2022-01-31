package local.example.aleatory;

import io.quarkus.vertx.web.Route;
import local.example.aleatory.service.AleatoryService;

import javax.ws.rs.core.MediaType;
import java.security.SecureRandom;

public class AleatoryResource {

    @Route(
            produces = MediaType.TEXT_PLAIN,
            methods = Route.HttpMethod.GET,
            path = "/aleatory"
    )
    public double aleatory() {
        int index;
        double[] temp;
        SecureRandom secureRandom = new SecureRandom();
        AleatoryService aleatoryService = new AleatoryService();
        temp = aleatoryService.getUncorrelatedRandomVector();
        index = (int) (256 * secureRandom.nextDouble());
        return temp[index];
    }

    @Route(
            produces = MediaType.TEXT_PLAIN,
            methods = Route.HttpMethod.GET,
            path = "/raw"
    )
    public double raw() {
        AleatoryService aleatoryService = new AleatoryService();
        return aleatoryService.getUniformRandomProvider();
    }
}
