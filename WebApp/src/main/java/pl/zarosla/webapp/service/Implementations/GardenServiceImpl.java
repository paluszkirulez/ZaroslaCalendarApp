package pl.zarosla.webapp.service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.BusinessModule.AuthenticationChecker;
import pl.zarosla.webapp.dao.GardenDao;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.User;
import pl.zarosla.webapp.service.GardenService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GardenServiceImpl implements GardenService {

    private static Logger logger = LoggerFactory.getLogger(GardenServiceImpl.class);

    @Autowired
    private GardenDao gardenDao;
    @Autowired
    public GardenServiceImpl(GardenDao gardenDao){this.gardenDao=gardenDao;}

    @Override
    public List<Garden> listAllGardens() {
        return (List<Garden>) gardenDao.findAll();
    }

    @Override
    public Optional<Garden> findGardensById(Long gardenId) {
        return gardenDao.findById(gardenId);
    }

    @Override
    public List<Garden> findGardensByUser(User user) {
        return gardenDao.findAllByUser(user);
    }



    @Override
    public void saveGarden(Garden garden) {
        garden.setUser(AuthenticationChecker.gatCurrentAuthentication().getUser());
        Date tempDate = new Date();
        java.sql.Date tempDate2 = new java.sql.Date(tempDate.getTime());
        garden.setCreationDate(tempDate2);
        gardenDao.save(garden);
    }

    @Override
    public void deleteGarden(Long gardenId) {
        gardenDao.deleteById(gardenId);
    }
}
