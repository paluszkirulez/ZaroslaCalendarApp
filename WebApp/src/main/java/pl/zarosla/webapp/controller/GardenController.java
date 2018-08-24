package pl.zarosla.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.service.GardenService;
import pl.zarosla.webapp.service.UserService;

@Controller
public class GardenController {
    private static final Logger log = LoggerFactory.getLogger(GardenController.class);

    private GardenService gardenService;

    @Autowired
    public GardenController(GardenService gardenService){this.gardenService=gardenService;}

    @GetMapping("/all-gardens")
    public String getAllGardens(Model model) {
        model.addAttribute("gardens", gardenService.listAllGardens());

        return "gardens";
    }
}
