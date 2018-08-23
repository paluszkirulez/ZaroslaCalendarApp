package pl.zarosla.webapp.service;

import pl.zarosla.webapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listAllUsers();
    Optional<User> findUserByID(Long userId);
    Optional<User> findUserByEmail(String email);
    void saveUser(User user);
    void deleteUser(Long userId);

}
