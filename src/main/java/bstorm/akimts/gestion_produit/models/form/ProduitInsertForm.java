package bstorm.akimts.gestion_produit.models.form;

import bstorm.akimts.gestion_produit.constraints.ProduitValid;
import bstorm.akimts.gestion_produit.constraints.TrimSize;
import bstorm.akimts.gestion_produit.models.entities.Produit;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Validated
//@ProduitValid
public class ProduitInsertForm {

    // Je veux que le prix soit toujours le nombre de lettre du nom / 1.5
    // Je veux que si la marque est avec un id de 1, le prix soit entre 5 et 10
    //  si l'id est de 2, le prix devra être entre 10(exclu) et 15

    @NotBlank
    @TrimSize(min = 4, max = 40)
    private String nom; // trim
    @NotNull
    @Min(0)
    private Double prix;
    @Min(1)
    private long marque_id; // existe

    public Produit mapToEntity(){
        return new Produit(
                0,
                nom,
                prix,
                null
        );
    }

}
