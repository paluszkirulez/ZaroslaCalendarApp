package pl.zarosla.webapp.service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.BusinessModule.MyUserPrincipal;
import pl.zarosla.webapp.dao.UserDao;
import pl.zarosla.webapp.domain.User;
import pl.zarosla.webapp.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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
    public UserDetails findUserByEmail(String email){
        User myUser = userDao.findDistinctByEmail(email);
        if(myUser == null){
            throw new UsernameNotFoundException(email);
        }
        return new MyUserPrincipal(myUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser = userDao.findDistinctByEmail(username);

        if(myUser == null){
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(myUser);
    }
}
