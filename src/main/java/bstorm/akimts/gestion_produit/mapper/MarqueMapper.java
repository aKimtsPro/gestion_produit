package bstorm.akimts.gestion_produit.mapper;

import bstorm.akimts.gestion_produit.models.dto.MarqueDTO;
import bstorm.akimts.gestion_produit.models.entities.Marque;
import org.springframework.stereotype.Service;

@Service
public class MarqueMapper {

    public MarqueDTO toDTO(Marque entity){
        if( entity == null )
            return null;

        return MarqueDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .build();
    }

}
