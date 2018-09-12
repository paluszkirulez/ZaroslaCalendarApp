package pl.zarosla.webapp.domain;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.Collection;
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

    private boolean active=false;
    private boolean activated = false;
    private boolean locked = false;
    private boolean expired = false;
    private int userType=1;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private Set<Garden> gardens;



    public User(String email, String name, String surname, String password, String avatarPicture, boolean active, boolean activated, boolean locked, boolean expired, int userType, Collection<Role> roles, Set<Garden> gardens) {
        String hashed = new BCryptPasswordEncoder(11).encode(password);
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = hashed;
        this.avatarPicture = avatarPicture;
        this.active = active;
        this.activated = activated;
        this.locked = locked;
        this.expired = expired;
        this.userType = userType;
        this.roles = roles;
        this.gardens = gardens;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", avatarPicture='" + avatarPicture + '\'' +
                ", active=" + active +
                ", activated=" + activated +
                ", locked=" + locked +
                ", expired=" + expired +
                ", userType=" + userType +
                ", gardens=" + gardens +
                '}';
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

        String hashed = new BCryptPasswordEncoder(11).encode(password);
        this.password = hashed;
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
