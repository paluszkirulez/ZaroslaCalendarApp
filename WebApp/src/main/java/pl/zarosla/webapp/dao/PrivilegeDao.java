package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.Privilege;

@Repository
public interface PrivilegeDao extends CrudRepository<Privilege,Long> {
    Privilege findByName(String name);
}
