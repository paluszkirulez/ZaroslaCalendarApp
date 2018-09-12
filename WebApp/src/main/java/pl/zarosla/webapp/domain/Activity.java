package pl.zarosla.webapp.domain;

import pl.zarosla.webapp.BusinessModule.ActivitiesTypes;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Plant plant;

    @ManyToOne
    private ActivityType activityType;

    private ActivitiesTypes activityTypeName;
    private String activityTypeNameString;
    @Column(length = 1024)
    private String notatka;

    private Date activityDate;

    public Activity() {
    }

    public void setActivityTypeName(ActivitiesTypes activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public String getActivityTypeNameString() {
        return activityTypeNameString;
    }

    public void setActivityTypeNameString(String activityTypeNameString) {
        this.activityTypeNameString = activityTypeNameString;
    }

    public Activity(Plant plant, ActivityType activityType, String activityTypeNameString, String notatka, Date activityDate) {
        this.plant = plant;
        this.activityType = activityType;
        this.activityTypeNameString=activityTypeNameString;
        this.activityTypeName = ActivitiesTypes.valueOf(activityTypeNameString);
        this.notatka = notatka;
        this.activityDate = activityDate;
    }

    public ActivitiesTypes getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeNameString) {
        this.activityTypeName = ActivitiesTypes.valueOf(activityTypeNameString);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getNotatka() {
        return notatka;
    }

    public void setNotatka(String notatka) {
        this.notatka = notatka;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public User getUser(){
        return this.getPlant().getGarden().getUser();
    }
}
