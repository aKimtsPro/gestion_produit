package bstorm.akimts.gestion_produit.service.impl;

import bstorm.akimts.gestion_produit.exception.ElementNotFoundException;
import bstorm.akimts.gestion_produit.exception.MarqueNotFoundException;
import bstorm.akimts.gestion_produit.mapper.ProduitMapper;
import bstorm.akimts.gestion_produit.models.dto.ProduitDTO;
import bstorm.akimts.gestion_produit.models.entities.Marque;
import bstorm.akimts.gestion_produit.models.entities.Produit;
import bstorm.akimts.gestion_produit.models.form.ProduitInsertForm;
import bstorm.akimts.gestion_produit.repository.MarqueRepository;
import bstorm.akimts.gestion_produit.repository.ProduitRepository;
import bstorm.akimts.gestion_produit.service.spec.ProduitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository repository;
    private final MarqueRepository marqueRepository;
    private final ProduitMapper mapper;

    public ProduitServiceImpl(ProduitRepository repository, MarqueRepository marqueRepository, ProduitMapper mapper) {
        this.repository = repository;
        this.marqueRepository = marqueRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProduitDTO> getAll() {

        return repository.findAll()
                .stream()
                .map( mapper::toDTO )
                .collect(Collectors.toList());

    }

    @Override
    public ProduitDTO getOne(long id) {

        return repository.findById(id)
                .map( mapper::toDTO )
                .orElseThrow( ElementNotFoundException::new );

    }

    @Override
    public ProduitDTO insert(ProduitInsertForm form)  {

        if( form == null )
            throw new IllegalArgumentException("form should not be null");

        Marque marque = marqueRepository.findById(form.getMarque_id())
                .orElseThrow(() -> new MarqueNotFoundException(form.getMarque_id()));

        Produit produit = form.mapToEntity();
        produit.setMarque( marque );

        return mapper.toDTO( repository.save(produit) );

    }
}
