package pl.zarosla.webapp.BusinessModule;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.zarosla.webapp.domain.User;

import java.util.Collection;
import java.util.Optional;

public class MyUserPrincipal implements UserDetails{

    private User user;
    public MyUserPrincipal(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    public Long getId() {return user.getId();}

    public User getUser(){
        return this.user;
    }
}
