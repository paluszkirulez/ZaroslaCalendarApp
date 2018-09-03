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
import pl.zarosla.webapp.dao.PlantDao;
import pl.zarosla.webapp.domain.Activity;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.Plant;
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

        Plant plant = plantDao.findById(plantid).get();
        if(!AuthenticationChecker.checkAuthentication(plant.getUser().getId())){
            return "redirect:/user-gardens";
        }

        model.addAttribute("activities",activityService.findActivityByPlant(plantDao.findById(plantid).get()));
        model.addAttribute("plantid",plantid);
        return "activities";
    }

    @PostMapping("/user-plants/activities/add/{plantid}")
    public String saveActivity(@ModelAttribute("plantid") long plantid, @ModelAttribute Activity activity){

        Plant plant = plantDao.findById(plantid).get();
        if(!AuthenticationChecker.checkAuthentication(plant.getUser().getId())){
            return "redirect:/user-gardens";
        }
        activity.setPlant(plantDao.findById(plantid).get());

        log.info("saveActivity(), activity(): {}", activity);
        activityService.saveActivity(activity);
        return "redirect:/user-plants/activities/"+plantid;
    }

    @GetMapping("/user-plants/activities/add/{plantid}")
    public String addActivity(@PathVariable("plantid") long plantid, Model model) {
        Plant plant = plantDao.findById(plantid).get();
        if(!AuthenticationChecker.checkAuthentication(plant.getUser().getId())){
            return "redirect:/user-gardens";
        }
        model.addAttribute("plantid", plantid);
        model.addAttribute("newactivity", new Activity());

        return "activity-add";
    }
    @GetMapping("/user-plants/delete-activity/{id}")
    String deleteChoice(@PathVariable("id") long activityId, Model model) {
        Plant plant = activityService.findActivityById(activityId).get().getPlant();
        Long plantid = plant.getId();
        if(!AuthenticationChecker.checkAuthentication(plant.getUser().getId())){
            return "redirect:/user-plants/activities/"+plantid;
        }
        model.addAttribute("bId", activityId);
        model.addAttribute("plantid",plantid);
        return "delete-activity";
    }

    @GetMapping("/user-plants/activity/delete/{deleteId}")
    String deleteActivity(@PathVariable("deleteId") long activityid, Model model) {

        Plant plant = activityService.findActivityById(activityid).get().getPlant();
        Long plantid = plant.getId();
        if(!AuthenticationChecker.checkAuthentication(plant.getUser().getId())){
            return "redirect:/user-plants/activities/"+plantid;
        }
        log.info("deleteActivity(), id: {}", activityid);
        model.addAttribute("plantid",plantid);
        activityService.deleteActivity(activityid);

        return "redirect:/user-plants/activities/"+plantid;
    }
}
