package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.Plant;
import pl.zarosla.webapp.domain.User;

import java.util.List;

@Repository
public interface PlantDao extends CrudRepository<Plant, Long> {
    List<Plant> findAllByGarden(Garden garden);
}
