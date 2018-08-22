package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.Plant;

@Repository
public interface PlantDao extends CrudRepository<Plant, Long> {
}
