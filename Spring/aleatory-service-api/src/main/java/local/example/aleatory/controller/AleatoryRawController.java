package local.example.aleatory.controller;

import local.example.aleatory.service.AleatoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AleatoryRawController {

    @RequestMapping(
            value = "/raw",
            method = RequestMethod.GET
    )
    public double rawResponse() {
        AleatoryService aleatoryService = new AleatoryService();
        return aleatoryService.getUniformRandomProvider();
    }
}
