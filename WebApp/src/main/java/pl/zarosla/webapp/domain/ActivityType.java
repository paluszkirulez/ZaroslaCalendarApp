package pl.zarosla.webapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String activityType;

    @OneToMany
    @JoinColumn(name="ACTIVITY_TYPE_ID")
    private List<Activity> activities;

    public ActivityType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
