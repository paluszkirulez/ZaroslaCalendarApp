package pl.zarosla.webapp.service;

import pl.zarosla.webapp.domain.Garden;

import java.util.List;
import java.util.Optional;

public interface GardenService {
    List<Garden> listAllGardens();
    Optional<Garden> findGardensById(Long gardenId);
    List<Garden> findGardensByUser(Long userId);
    void saveGarden(Garden garden);
    void deleteGarden(Long gardenId);

}
