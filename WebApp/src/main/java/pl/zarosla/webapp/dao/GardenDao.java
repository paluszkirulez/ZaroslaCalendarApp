package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GardenDao extends CrudRepository<Garden, Long> {

    List<Garden> findAllByUser(User user);
}
