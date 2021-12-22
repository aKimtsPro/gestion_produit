package bstorm.akimts.gestion_produit.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldErrorDTO {

    private String message;
    private String fieldName;

}
