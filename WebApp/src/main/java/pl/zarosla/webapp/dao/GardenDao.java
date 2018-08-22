package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.Garden;

@Repository
public interface GardenDao extends CrudRepository<Garden, Long> {
}
