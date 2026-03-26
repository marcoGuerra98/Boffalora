package com.boffa.project.service;

import com.boffa.project.entity.UserEntity;
import com.boffa.project.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(userName);
        System.out.println("Caricamento utente: " + user.getUserName());
        System.out.println("Ruolo utente: " + user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("Utente non trovato");
        }

        return User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRuolo().replace("ROLE_", ""))
                .build();
    }

}
