package pl.zarosla.webapp.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Garden garden;

    private boolean presentOrPlanned;
    private Date plantingDate;
    private Date wateredDate;
    private int wateringFrequency;
    private Date transplantationDate;
    private Date fertilizingDate;
    private Date lastActivityDate;
    private Date nextWateringDate;
    private String species;
    private String type;
    private String name;
    private int status;
    @OneToMany
    @JoinColumn(name="PLANT_ID")
    private Set<Activity> activities;

    public Date getFertilizingDate() {
        return fertilizingDate;
    }

    public void setFertilizingDate(Date fertilizingDate) {
        this.fertilizingDate = fertilizingDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getNextWateringDate() {
        return nextWateringDate;
    }

    public void setNextWateringDate(Date nextWateringDate) {
        this.nextWateringDate = nextWateringDate;
    }

    @Column(length = 1024)
    private String notatka;

    public Plant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public boolean isPresentOrPlanned() {
        return presentOrPlanned;
    }

    public void setPresentOrPlanned(boolean presentOrPlanned) {
        this.presentOrPlanned = presentOrPlanned;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }
    public String getPlantingDateAsString(){return String.valueOf(plantingDate);}

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public Date getWateredDate() {
        return wateredDate;
    }

    public void setWateredDate(Date witheredDate) {
        this.wateredDate = witheredDate;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public Date getTransplantationDate() {
        return transplantationDate;
    }

    public void setTransplantationDate(Date transplantationDate) {
        this.transplantationDate = transplantationDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public User getUser(){
        return this.getGarden().getUser();
    }

    public String getNotatka() {
        return notatka;
    }

    public void setNotatka(String notatka) {
        this.notatka = notatka;
    }


    public Plant(Garden garden, boolean presentOrPlanned, Date plantingDate, Date wateredDate, int wateringFrequency, Date transplantationDate, Date fertilizingDate, Date lastActivityDate, Date nextWateringDate, String species, String type, String name, int status, Set<Activity> activities, String notatka) {
        this.garden = garden;
        this.presentOrPlanned = presentOrPlanned;
        this.plantingDate = plantingDate;
        this.wateredDate = wateredDate;
        this.wateringFrequency = wateringFrequency;
        this.transplantationDate = transplantationDate;
        this.fertilizingDate = fertilizingDate;
        this.lastActivityDate = lastActivityDate;
        this.nextWateringDate = nextWateringDate;
        this.species = species;
        this.type = type;
        this.name = name;
        this.status = status;
        this.activities = activities;
        this.notatka = notatka;
        this.garden.setNumberOfPlants(garden.getNumberOfPlants()+1);
    }
}