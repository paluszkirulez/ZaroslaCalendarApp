package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import pl.zarosla.webapp.domain.Activity;
import pl.zarosla.webapp.domain.Plant;

import java.util.List;

public interface ActivityDao extends CrudRepository<Activity,Long> {
    List<Activity> findAllByPlant(Plant plant);
}
