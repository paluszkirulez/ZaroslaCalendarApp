package pl.zarosla.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.zarosla.webapp.BusinessModule.MyUserPrincipal;
import pl.zarosla.webapp.dao.PlantDao;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.service.ActivityService;

@Controller
public class ActivityController {
    private static final Logger log = LoggerFactory.getLogger(ActivityController.class);

    private ActivityService activityService;
    @Autowired
    public PlantDao plantDao;

    @Autowired
    public ActivityController(ActivityService activityService){this.activityService = activityService;}

    @GetMapping("/user-plants/activities/{id}")
    public String getGardenPlants(@PathVariable("id") long plantid, Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal myUser = (MyUserPrincipal) authentication.getPrincipal();


        model.addAttribute("activities",activityService.findActivityByPlant(plantDao.findById(plantid).get()));

        model.addAttribute("plantid",plantid);
        return "activities";
    }
}
