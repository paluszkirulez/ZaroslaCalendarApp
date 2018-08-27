package pl.zarosla.webapp.service;

import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {
    List<Plant> listAllPlants();
    Optional<Plant> findPlantById(Long plantId);
    List<Plant> findPlantByGarden(Garden garden);
    void savePlant(Plant plant);
    void deletePlant(Long plantId);
}
