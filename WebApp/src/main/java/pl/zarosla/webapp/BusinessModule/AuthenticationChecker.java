package pl.zarosla.webapp.BusinessModule;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationChecker {
    static public MyUserPrincipal gatCurrentAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal myUser = (MyUserPrincipal) authentication.getPrincipal();

        return myUser;
    }

    static public boolean checkAuthentication(Long idToCheck){
        return AuthenticationChecker.gatCurrentAuthentication().getId().equals(idToCheck);

    }
}
