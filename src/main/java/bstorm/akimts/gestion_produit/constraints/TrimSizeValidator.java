package bstorm.akimts.gestion_produit.constraints;

import bstorm.akimts.gestion_produit.models.form.ProduitInsertForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrimSizeValidator implements ConstraintValidator<TrimSize, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {
            Class<ProduitInsertForm> clazz = ProduitInsertForm.class;

            TrimSize constraint = clazz.getDeclaredField("nom").getAnnotation(TrimSize.class);
            int min = constraint.min();
            int max = constraint.max();

            value = value.trim();
            if( value.length() >= min && value.length() <= max )
                return true;

        }catch (Exception ignored){}

        return false;
    }
}
