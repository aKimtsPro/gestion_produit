package bstorm.akimts.gestion_produit.constraints;

import bstorm.akimts.gestion_produit.models.form.ProduitInsertForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProduitValidator implements ConstraintValidator<ProduitValid, ProduitInsertForm> {


    @Override
    public boolean isValid(ProduitInsertForm value, ConstraintValidatorContext context) {


        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        if( value.getNom().length() / 1.5 != value.getPrix() ){
            isValid = false;
            context.buildConstraintViolationWithTemplate("le prix d'un produit devrait être = la taille du nom / 1.5")
                    .addConstraintViolation();
        }

        if( value.getMarque_id() == 1 && ( value.getPrix() > 10 || value.getPrix() < 5 ) ){
            isValid = false;
            context.buildConstraintViolationWithTemplate("le prix devrait être entre 5 et 10 si l'id de la marque est de 1")
                    .addConstraintViolation();
        }

        if( value.getMarque_id() == 2 && ( value.getPrix() > 15 || value.getPrix() <= 10 ) ){
            isValid = false;
            context.buildConstraintViolationWithTemplate("le prix devrait être entre 10(exclu) et 15 si l'id de la marque est de 2")
                    .addConstraintViolation();
        }

        return isValid;

    }
}
