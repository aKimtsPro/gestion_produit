package bstorm.akimts.gestion_produit.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitDTO {

    private long id;
    private String nom;
    private double prix;
    private MarqueDTO marque;

}
