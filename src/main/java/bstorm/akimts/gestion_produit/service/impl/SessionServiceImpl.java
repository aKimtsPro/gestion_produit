package bstorm.akimts.gestion_produit.service.impl;

import bstorm.akimts.gestion_produit.config.security.jwt.JwtTokenProvider;
import bstorm.akimts.gestion_produit.models.dto.SmallUserDTO;
import bstorm.akimts.gestion_produit.models.form.UserLoginForm;
import bstorm.akimts.gestion_produit.models.entities.User;
import bstorm.akimts.gestion_produit.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl {

    private final AuthenticationManager authManager;
    private final UserRepository repository;
    private final JwtTokenProvider tokenProvider;

    public SessionServiceImpl(AuthenticationManager authManager, UserRepository repository, JwtTokenProvider tokenProvider) {
        this.authManager = authManager;
        this.repository = repository;
        this.tokenProvider = tokenProvider;
    }

    public SmallUserDTO signIn(UserLoginForm form){

        try {
            authManager.authenticate( new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()) );
            User user = repository.findByUsername(form.getUsername()).orElseThrow(() -> new UsernameNotFoundException("username not found"));
            String token = tokenProvider.createToken(user.getUsername(), user.getRoles());
            return SmallUserDTO.builder()
                    .token(token)
                    .username(user.getUsername())
                    .build();
        } catch (AuthenticationException exception){
            throw new RuntimeException("Username/Password invalides");
        }

    }
}
