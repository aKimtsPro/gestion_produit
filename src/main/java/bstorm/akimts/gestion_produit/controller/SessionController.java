package bstorm.akimts.gestion_produit.controller;

import bstorm.akimts.gestion_produit.models.dto.SmallUserDTO;
import bstorm.akimts.gestion_produit.models.form.UserLoginForm;
import bstorm.akimts.gestion_produit.service.impl.SessionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpHeaders;

@RestController
public class SessionController {

    private final SessionServiceImpl sessionService;

    public SessionController(SessionServiceImpl sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<SmallUserDTO> login(@Valid @RequestBody UserLoginForm form){
        return  ResponseEntity.ok(sessionService.signIn(form));
    }

    @GetMapping("/is-logged")
    public boolean isLogged(){
        return true;
    }
}
