package bstorm.akimts.gestion_produit.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorDTO {

    public List<String> globalErrors = new ArrayList<>();
    public List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ValidationErrorDTO() {
    }
}
