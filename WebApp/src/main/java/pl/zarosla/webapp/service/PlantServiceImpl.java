package pl.zarosla.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.dao.PlantDao;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.Plant;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    private static Logger logger = LoggerFactory.getLogger(PlantServiceImpl.class);

    private PlantDao plantDao;

    @Override
    public List<Plant> listAllPlants() {
        return (List<Plant>) plantDao.findAll();
    }

    @Override
    public Optional<Plant> findPlantById(Long plantId) {
        return plantDao.findById(plantId);
    }

    @Override
    public List<Plant> findPlantByGarden(Garden garden) {
        return plantDao.findAllByGarden(garden);
    }

    @Override
    public void savePlant(Plant plant) {
        plantDao.save(plant);

    }

    @Override
    public void deletePlant(Long plantId) {
        plantDao.deleteById(plantId);
    }
}
