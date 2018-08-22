package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import pl.zarosla.webapp.domain.Activity;

public interface ActivityDao extends CrudRepository<Activity,Long> {
}
