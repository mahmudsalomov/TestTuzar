package Laboratoriya.uchun.Laboratoriya.component;

import Laboratoriya.uchun.Laboratoriya.model.user.User;
import Laboratoriya.uchun.Laboratoriya.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.Collection;
import java.util.Collections;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        return new CustomUserDetails(user);
    }
//    public User loadUserByUsername2(String username){
//        return userRepo.findByUsername(username);
//    }
}
