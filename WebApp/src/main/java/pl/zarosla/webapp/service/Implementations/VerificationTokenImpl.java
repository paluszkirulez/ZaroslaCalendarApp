package pl.zarosla.webapp.service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zarosla.webapp.dao.VerificationTokenDao;
import pl.zarosla.webapp.domain.VerificationToken;
import pl.zarosla.webapp.service.VerificationTokenService;


@Service
public class VerificationTokenImpl implements VerificationTokenService {


    private VerificationTokenDao verificationTokenDao;

    @Autowired
    public VerificationTokenImpl(VerificationTokenDao verificationTokenDao){this.verificationTokenDao=verificationTokenDao;}

    @Override
    public void saveVerificatonToke(VerificationToken verificationToken) {
        verificationTokenDao.save(verificationToken);
    }
}
