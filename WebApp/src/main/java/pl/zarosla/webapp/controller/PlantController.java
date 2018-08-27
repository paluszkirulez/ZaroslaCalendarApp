package pl.zarosla.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.zarosla.webapp.dao.GardenDao;
import pl.zarosla.webapp.service.PlantService;

@Controller
public class PlantController {
    private static final Logger log = LoggerFactory.getLogger(PlantController.class);

    private PlantService plantService;
    private GardenDao gardenDao;

    @Autowired
    public PlantController(PlantService plantService){this.plantService = plantService;}

    @GetMapping("/user-plants/{gardenid}")
    public String getGardenPlants(@PathVariable("gardenid") long gardenId, Model model){
        model.addAttribute("gardenid",gardenId);
        model.addAttribute("plants",plantService.listAllPlants());
        return "plants";
    }

}
