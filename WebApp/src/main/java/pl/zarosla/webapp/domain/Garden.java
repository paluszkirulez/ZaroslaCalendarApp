package pl.zarosla.webapp.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String name;
    private Date creationDate;
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="GARDEN_ID")
    private Set<Plant> plants;

    public Garden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    public void setPlants(Set<Plant> plants) {
        this.plants = plants;
    }

    public Garden(User user, String name, Date creationDate, boolean active, Set<Plant> plants) {
        this.user = user;
        this.name = name;
        this.creationDate = creationDate;
        this.active = active;
        this.plants = plants;
    }
}
