package pl.zarosla.webapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import pl.zarosla.webapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listAllUsers();
    Optional<User> findUserByID(Long userId);
    UserDetails findUserByEmail(String email);
    void saveUser(User user);
    void deleteUser(Long userId);


}
