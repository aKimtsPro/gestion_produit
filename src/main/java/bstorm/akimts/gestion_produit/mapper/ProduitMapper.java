package bstorm.akimts.gestion_produit.mapper;

import bstorm.akimts.gestion_produit.models.dto.ProduitDTO;
import bstorm.akimts.gestion_produit.models.entities.Produit;
import org.springframework.stereotype.Service;

@Service
public class ProduitMapper {

    private final MarqueMapper marqueMapper;

    public ProduitMapper(MarqueMapper marqueMapper) {
        this.marqueMapper = marqueMapper;
    }

    public ProduitDTO toDTO(Produit entity){

        if( entity == null )
            return null;

        return ProduitDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prix(entity.getPrix())
                .marque( marqueMapper.toDTO(entity.getMarque()) )
                .build();

    }

}
