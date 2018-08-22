package pl.zarosla.webapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String name;
    private String surname;
    private String password;
    private String avatarPicture;
    private boolean active;
    private int userType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_IDb")
    private Set<Garden> gardens;

    public User(String email, String name, String surname, String password, String avatarPicture, boolean active, int userType, Set<Garden> gardens) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.avatarPicture = avatarPicture;
        this.active = active;
        this.userType = userType;
        this.gardens = gardens;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarPicture() {
        return avatarPicture;
    }

    public void setAvatarPicture(String avatarPicture) {
        this.avatarPicture = avatarPicture;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Set<Garden> getGardens() {
        return gardens;
    }

    public void setGardens(Set<Garden> gardens) {
        this.gardens = gardens;
    }
}
