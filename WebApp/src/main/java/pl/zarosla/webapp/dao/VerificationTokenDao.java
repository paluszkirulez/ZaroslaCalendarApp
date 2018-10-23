package pl.zarosla.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zarosla.webapp.domain.VerificationToken;

@Repository
public interface VerificationTokenDao extends CrudRepository<VerificationToken, Long> {
}
