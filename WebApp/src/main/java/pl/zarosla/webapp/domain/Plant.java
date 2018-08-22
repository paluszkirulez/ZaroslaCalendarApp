package pl.zarosla.webapp.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @ForeignKey(name="ID_Country")
    private Garden garden;

    private boolean presentOrPlanned;
    private Date plantingDate;
    private Date witheredDate;
    private int wateringFrequency;
    private int transplantationDate;
    private String species;
    private String type;
    private String name;
    private int status;

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

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public Date getWitheredDate() {
        return witheredDate;
    }

    public void setWitheredDate(Date witheredDate) {
        this.witheredDate = witheredDate;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public int getTransplantationDate() {
        return transplantationDate;
    }

    public void setTransplantationDate(int transplantationDate) {
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

    public String getNotatka() {
        return notatka;
    }

    public void setNotatka(String notatka) {
        this.notatka = notatka;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", garden=" + garden +
                ", presentOrPlanned=" + presentOrPlanned +
                ", plantingDate=" + plantingDate +
                ", witheredDate=" + witheredDate +
                ", wateringFrequency=" + wateringFrequency +
                ", transplantationDate=" + transplantationDate +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", notatka='" + notatka + '\'' +
                '}';
    }

    public Plant(boolean presentOrPlanned, Date plantingDate, Date witheredDate, int wateringFrequency, int transplantationDate, String species, String type, String name, int status, String notatka) {
        this.presentOrPlanned = presentOrPlanned;
        this.plantingDate = plantingDate;
        this.witheredDate = witheredDate;
        this.wateringFrequency = wateringFrequency;
        this.transplantationDate = transplantationDate;
        this.species = species;
        this.type = type;
        this.name = name;
        this.status = status;
        this.notatka = notatka;
    }
}
