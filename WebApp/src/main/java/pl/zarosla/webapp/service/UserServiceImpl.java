package pl.zarosla.webapp.service;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.dao.UserDao;
import pl.zarosla.webapp.domain.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    //Criteria criteria = session.

    @Autowired
    public UserServiceImpl(UserDao userDao){this.userDao=userDao;}



    @Override
    public List<User> listAllUsers() {

        return (List<User>) userDao.findAll();
    }

    @Override
    public Optional<User> findUserByID(Long userId) {
        return userDao.findById(userId);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email){
        return userDao.findDistinctByEmail(email);
    }
}
