package pl.zarosla.webapp.service;

import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface GardenService {
    List<Garden> listAllGardens();
    Optional<Garden> findGardensById(Long gardenId);
    List<Garden> findGardensByUser(User user);
    void saveGarden(Garden garden);
    void deleteGarden(Long gardenId);

}
