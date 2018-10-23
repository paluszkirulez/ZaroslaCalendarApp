package pl.zarosla.webapp.service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.BusinessModule.EmailComposer;
import pl.zarosla.webapp.BusinessModule.MyUserPrincipal;
import pl.zarosla.webapp.dao.RoleDao;
import pl.zarosla.webapp.dao.UserDao;
import pl.zarosla.webapp.dao.VerificationTokenDao;
import pl.zarosla.webapp.domain.Role;
import pl.zarosla.webapp.domain.User;
import pl.zarosla.webapp.domain.VerificationToken;
import pl.zarosla.webapp.service.UserService;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    //Criteria criteria = session.

    @Autowired
    public UserServiceImpl(UserDao userDao){this.userDao=userDao;}

    @Autowired
    public RoleDao roleDao;

    @Autowired
    public VerificationTokenDao verificationTokenDao;

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
        Set<Role> userDefaultRoles = new HashSet<>();
        userDefaultRoles.add(roleDao.findById(Long.valueOf(4)).get());
        user.setRoles(userDefaultRoles);
        userDao.save(user);
        VerificationToken token = new VerificationToken(user);
        verificationTokenDao.save(token);
        try {
            EmailComposer.registrationEmail(user.getEmail(),token.getToken());
        } catch (MessagingException e) {
            e.printStackTrace();
        }


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
