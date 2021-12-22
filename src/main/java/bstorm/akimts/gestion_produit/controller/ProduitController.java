package bstorm.akimts.gestion_produit.controller;

import bstorm.akimts.gestion_produit.models.dto.ProduitDTO;
import bstorm.akimts.gestion_produit.models.form.ProduitInsertForm;
import bstorm.akimts.gestion_produit.service.spec.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/produit/response
    @GetMapping("/response")
    @ResponseStatus( HttpStatus.OK )
    public List<ProduitDTO> getAllWithResponseEntity(){
        return service.getAll();
    }

    // GET - http://localhost:8080/produit
    @GetMapping
    public ResponseEntity<List<ProduitDTO>> getAll(){
        return ResponseEntity.ok( service.getAll() );
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .header("mon header", "sa valeur")
//                .body( service.getAll() );
    }

    // GET - http://localhost:8080/produit  ?id=x
    @GetMapping(params = {"id"})
    public ResponseEntity<ProduitDTO> getOne(@RequestParam long id){
        return ResponseEntity.ok( service.getOne(id) );
    }

    // GET - http://localhost:8080/produit/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getOnePath(@PathVariable long id){
        return ResponseEntity.ok( service.getOne(id) );
    }

    @PostMapping(path = {"", "/add"})
    public ResponseEntity<ProduitDTO> insert( @Valid @RequestBody ProduitInsertForm form){
        return ResponseEntity.ok( service.insert(form) );
    }
}
