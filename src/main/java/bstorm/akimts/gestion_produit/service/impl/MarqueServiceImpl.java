package bstorm.akimts.gestion_produit.service.impl;

import bstorm.akimts.gestion_produit.mapper.MarqueMapper;
import bstorm.akimts.gestion_produit.models.dto.MarqueDTO;
import bstorm.akimts.gestion_produit.repository.MarqueRepository;
import bstorm.akimts.gestion_produit.service.spec.MarqueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarqueServiceImpl implements MarqueService {

    private final MarqueRepository repository;
    private final MarqueMapper mapper;

    public MarqueServiceImpl(MarqueRepository repository, MarqueMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MarqueDTO> getAll() {
        return repository.findAll().stream()
                .map( mapper::toDTO )
                .collect(Collectors.toList());
    }
}
