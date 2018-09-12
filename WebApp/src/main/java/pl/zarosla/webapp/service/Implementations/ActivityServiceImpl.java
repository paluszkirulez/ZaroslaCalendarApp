package pl.zarosla.webapp.service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.BusinessModule.DateUtil;
import pl.zarosla.webapp.dao.ActivityDao;
import pl.zarosla.webapp.dao.PlantDao;
import pl.zarosla.webapp.domain.Activity;
import pl.zarosla.webapp.domain.Plant;
import pl.zarosla.webapp.service.ActivityService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ActivityServiceImpl implements ActivityService {


    private static Logger logger = LoggerFactory.getLogger(GardenServiceImpl.class);

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private PlantDao plantDao;

    @Override
    public List<Activity> listAllActivities() {
        return (List<Activity>) activityDao.findAll();
    }

    @Override
    public Optional<Activity> findActivityById(Long activityId) {
        return activityDao.findById(activityId);
    }

    @Override
    public List<Activity> findActivityByPlant(Plant plant) {
        return activityDao.findAllByPlant(plant);
    }

    @Override
    public void saveActivity(Activity activity) {
        Date date = new Date();
        java.sql.Date myDate = new java.sql.Date(date.getTime());
        activity.setActivityDate(myDate);

        //override date for plants
        Plant tempPlant = activity.getPlant();
        if("watering".equalsIgnoreCase(activity.getActivityTypeNameString())){

            tempPlant.setWateredDate(myDate);
            Date tempDate = DateUtil.addDays(date,tempPlant.getWateringFrequency());
            tempPlant.setNextWateringDate(new java.sql.Date(tempDate.getTime()));
        } else if("fertilizing".equalsIgnoreCase(activity.getActivityTypeNameString())){
            tempPlant.setFertilizingDate(myDate);
        } else if("transplantation".equalsIgnoreCase(activity.getActivityTypeNameString())){
            tempPlant.setTransplantationDate(myDate);
        }
        tempPlant.setLastActivityDate(myDate);

        activityDao.save(activity);
        plantDao.save(tempPlant);

    }

    @Override
    public void deleteActivity(Long activityId) {
        activityDao.deleteById(activityId);
    }
}
