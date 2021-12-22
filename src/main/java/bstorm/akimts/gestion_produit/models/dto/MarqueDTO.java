package bstorm.akimts.gestion_produit.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MarqueDTO {

    private long id;
    private String nom;

}
