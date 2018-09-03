package pl.zarosla.webapp.service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.dao.GardenDao;
import pl.zarosla.webapp.dao.PlantDao;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.Plant;
import pl.zarosla.webapp.service.PlantService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    private static Logger logger = LoggerFactory.getLogger(PlantServiceImpl.class);

    @Autowired
    private PlantDao plantDao;

    @Autowired
    private GardenDao gardenDao;

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
        Date date = new Date();
        java.sql.Date myDate = new java.sql.Date(date.getTime());
        plant.setPlantingDate(myDate);
        plant.setStatus(1);
        plantDao.save(plant);
        Garden tempGarden = plant.getGarden();
        tempGarden.setNumberOfPlants(tempGarden.getNumberOfPlants()+1);
        gardenDao.save(plant.getGarden());

    }

    @Override
    public void deletePlant(Long plantId) {
        Plant tempPlant = plantDao.findById(plantId).get();
        Garden tempGarden = tempPlant.getGarden();
        plantDao.deleteById(plantId);
        tempGarden.setNumberOfPlants(tempGarden.getNumberOfPlants()-1);
        gardenDao.save(tempGarden);
    }
}
