package bstorm.akimts.gestion_produit.controller;

import bstorm.akimts.gestion_produit.models.dto.MarqueDTO;
import bstorm.akimts.gestion_produit.service.spec.MarqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marque")
public class MarqueController {

    private final MarqueService service;

    public MarqueController(MarqueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MarqueDTO>> getAll(){
        return ResponseEntity.ok( service.getAll() );
    }

}
