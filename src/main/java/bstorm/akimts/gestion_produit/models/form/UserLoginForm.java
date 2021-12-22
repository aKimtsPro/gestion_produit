package bstorm.akimts.gestion_produit.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
