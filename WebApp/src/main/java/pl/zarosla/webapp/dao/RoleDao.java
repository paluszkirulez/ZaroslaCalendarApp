package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.Role;

@Repository
public interface RoleDao extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
