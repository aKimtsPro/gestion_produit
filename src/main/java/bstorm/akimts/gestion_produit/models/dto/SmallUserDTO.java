package bstorm.akimts.gestion_produit.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmallUserDTO {

    private String username;
    private String token;

}
