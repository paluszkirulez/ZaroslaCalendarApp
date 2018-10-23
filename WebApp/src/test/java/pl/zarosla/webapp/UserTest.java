package pl.zarosla.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.zarosla.webapp.dao.UserDao;
import pl.zarosla.webapp.domain.Garden;
import pl.zarosla.webapp.domain.User;
import pl.zarosla.webapp.service.UserService;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {
    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private UserService userService;



    @Test
    public void checkUser(){
        User user = new User();
        userService.saveUser(user);
        System.out.println(user);
        Assert.assertEquals(1,1);

    }
}
