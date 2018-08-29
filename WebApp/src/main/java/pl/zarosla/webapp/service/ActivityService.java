package pl.zarosla.webapp.service;

import pl.zarosla.webapp.domain.Activity;
import pl.zarosla.webapp.domain.Plant;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<Activity> listAllActivities();
    Optional<Activity> findActivityById(Long activityId);
    List<Activity> findActivityByPlant(Plant plant);
    void saveActivity(Activity activity);
    void deleteActivity(Long activityId);
}
