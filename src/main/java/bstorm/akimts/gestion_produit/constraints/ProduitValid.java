package bstorm.akimts.gestion_produit.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ProduitValidator.class })
public @interface ProduitValid {

    String message() default "le produit n'est pas valide";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
