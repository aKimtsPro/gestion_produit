package bstorm.akimts.gestion_produit.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {ElementType.FIELD, ElementType.TYPE} )
@Retention( RetentionPolicy.RUNTIME )
@Constraint(validatedBy = { TrimSizeValidator.class })
public @interface TrimSize {

    String message() default "la taille trimé est invalide";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    int min() default 0;

    int max() default Integer.MAX_VALUE;


}
