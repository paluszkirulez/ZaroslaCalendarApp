package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.User;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    Optional<User> findDistinctByEmail(String email);
}
