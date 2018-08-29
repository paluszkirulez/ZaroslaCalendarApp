package pl.zarosla.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zarosla.webapp.BusinessModule.AuthenticationChecker;
import pl.zarosla.webapp.BusinessModule.MyUserPrincipal;
import pl.zarosla.webapp.dao.GardenDao;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.Plant;
import pl.zarosla.webapp.service.PlantService;

import java.util.Date;

@Controller
public class PlantController {
    private static final Logger log = LoggerFactory.getLogger(PlantController.class);

    private PlantService plantService;
    @Autowired
    private GardenDao gardenDao;

    @Autowired
    public PlantController(PlantService plantService){this.plantService = plantService;}

    @GetMapping("/user-plants/{id}")
    public String getGardenPlants(@PathVariable("id") long gardenid, Model model){

        Garden tempGarden = gardenDao.findById(gardenid).get();
        boolean checkUser = AuthenticationChecker.checkAuthentication(tempGarden.getUser().getId());

        model.addAttribute("plants",plantService
                .findPlantByGarden( checkUser ? tempGarden : null ));
        if(!checkUser){

            return "redirect:/user-gardens";
        }
        model.addAttribute("gardenid",gardenid);
        return "plants";
    }

    @PostMapping("/user-plants/add/{gardenid}")
    public String savePlant(@ModelAttribute("gardenid") long gardenid, @ModelAttribute Plant plant){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal myUser = (MyUserPrincipal) authentication.getPrincipal();

        Date date = new Date();
        java.sql.Date myDate = new java.sql.Date(date.getTime());
        plant.setPlantingDate(myDate);
        plant.setGarden(gardenDao.findById(gardenid).get());
        plant.setStatus(1);
        log.info("savePlant(), plant(): {}", plant);
        //System.out.println(plant.getId());
        plantService.savePlant(plant);
        return "redirect:/user-plants/{gardenid}";
    }

    @GetMapping("/user-plants/add/{gardenid}")
    public String addPlant(@PathVariable("gardenid") long gardenid, Model model) {
        model.addAttribute("gardenid", gardenid);
        model.addAttribute("newplant", new Plant());

        return "plants-add";
    }

    @GetMapping("/user-plants/delete-plant/{id}")
    String deleteChoice(@PathVariable("id") long plantId, Model model) {
        long gardenid = plantService.findPlantById(plantId).get().getGarden().getId();
        model.addAttribute("bId", plantId);
        model.addAttribute("gardenid",gardenid);
        return "delete-plant";
    }

    @GetMapping("/user-plants/delete/{deleteId}")
    String deleteBook(@PathVariable("deleteId") long plantId, Model model) {

        log.info("deletePlant(), id: {}", plantId);
        long gardenid = plantService.findPlantById(plantId).get().getGarden().getId();
        model.addAttribute("gardenid",gardenid);
        plantService.deletePlant(plantId);

        return "redirect:/user-plants/"+gardenid;
    }

}
