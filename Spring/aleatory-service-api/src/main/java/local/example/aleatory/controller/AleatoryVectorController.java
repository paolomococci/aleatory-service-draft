package local.example.aleatory.controller;

import local.example.aleatory.service.AleatoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AleatoryVectorController {

    @RequestMapping(
            value = "/vector",
            method = RequestMethod.GET
    )
    public double[] vectorResponse() {
        AleatoryService aleatoryService = new AleatoryService();
        return aleatoryService.getUncorrelatedRandomVector();
    }
}
