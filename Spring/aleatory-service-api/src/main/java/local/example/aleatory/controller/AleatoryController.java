package local.example.aleatory.controller;

import java.security.SecureRandom;

import local.example.aleatory.service.AleatoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AleatoryController {

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public double defaultResponse() {
        int index;
        double[] temp;
        SecureRandom secureRandom = new SecureRandom();
        AleatoryService aleatoryService = new AleatoryService();
        temp = aleatoryService.getUncorrelatedRandomVector();
        index = (int) (256 * secureRandom.nextDouble());
        return temp[index];
    }
}
