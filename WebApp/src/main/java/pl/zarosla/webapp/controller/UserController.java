package pl.zarosla.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zarosla.webapp.BusinessModule.EmailComposer;
import pl.zarosla.webapp.domain.User;
import pl.zarosla.webapp.domain.VerificationToken;
import pl.zarosla.webapp.service.UserService;
import pl.zarosla.webapp.service.VerificationTokenService;
import pl.zarosla.webapp.service.mail.EmailService;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService){this.userService = userService;}

    @PostMapping("/user/register")
    public String saveUser(@ModelAttribute User user){
        log.info("saveUser(), user(): {}", user);
        userService.saveUser(user);

        return "activation";
    }

    @GetMapping("/user/activation")
    public String activateUser(Model model){
        return "activation";
    }

    @GetMapping("/user/register")
    public String addUser(Model model) {
        model.addAttribute("newuser", new User());

        return "register";
    }

}
