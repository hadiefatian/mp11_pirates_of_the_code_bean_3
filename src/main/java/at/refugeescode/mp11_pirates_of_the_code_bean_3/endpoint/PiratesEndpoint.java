package at.refugeescode.mp11_pirates_of_the_code_bean_3.endpoint;

import at.refugeescode.mp11_pirates_of_the_code_bean_3.logic.PirateService;
import at.refugeescode.mp11_pirates_of_the_code_bean_3.persistence.Pirate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pirates")
public class PiratesEndpoint {

    private PirateService pirateService;

    public PiratesEndpoint(PirateService pirateService) {
        this.pirateService = pirateService;
    }

    @GetMapping
    List<Pirate> findAll() {
        pirateService.populatePirates();
        return pirateService.findAll();
    }

}
