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
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.User;
import pl.zarosla.webapp.service.GardenService;
import pl.zarosla.webapp.service.UserService;

import java.util.Date;


@Controller
public class GardenController {
    private static final Logger log = LoggerFactory.getLogger(GardenController.class);

    private GardenService gardenService;



    @Autowired
    public GardenController(GardenService gardenService){this.gardenService=gardenService;}

/*    @GetMapping("/all-gardens")
    public String getAllGardens(Model model) {
        model.addAttribute("gardens", gardenService.listAllGardens());

        return "gardens";
    }*/

    @GetMapping("/user-gardens")
    public String getUserGardens(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal myUser = (MyUserPrincipal) authentication.getPrincipal();
        model.addAttribute("gardens", gardenService.findGardensByUser(myUser.getUser()));

        return "gardens";
    }

    @PostMapping("/user-gardens")
    public String postUserGardens(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal myUser = (MyUserPrincipal) authentication.getPrincipal();
        model.addAttribute("gardens", gardenService.findGardensByUser(myUser.getUser()));

        return "gardens";
    }

    @PostMapping("/user-gardens/add")
    public String saveGarden(@ModelAttribute Garden garden){

        MyUserPrincipal myUser = AuthenticationChecker.gatCurrentAuthentication();




        log.info("saveGarden(), garden(): {}", garden);

        gardenService.saveGarden(garden);
        return "redirect:/user-gardens";
    }

    @GetMapping("/user-gardens/add")
    public String addGarden(Model model) {
        model.addAttribute("newgarden", new Garden());

        return "gardens-add";
    }

    @GetMapping("/user-gardens/delete-choice/{id}")
    String deleteChoice(@PathVariable("id") long gardenId, Model model) {
        model.addAttribute("bId", gardenId);

        return "delete-choice";
    }

    @GetMapping("/user-gardens/delete/{deleteId}")
    String deleteBook(@PathVariable("deleteId") long gardenId) {

        log.info("deleteGarden(), id: {}", gardenId);
        gardenService.deleteGarden(gardenId);

        return "redirect:/user-gardens";
    }
}
