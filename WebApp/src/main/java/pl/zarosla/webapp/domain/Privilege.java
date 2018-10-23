package pl.zarosla.webapp.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Privilege(String name) {
        this.name = name;
    }

    public Privilege() {
    }

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
