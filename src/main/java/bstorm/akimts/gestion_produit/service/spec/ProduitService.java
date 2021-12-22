package bstorm.akimts.gestion_produit.service.spec;

import bstorm.akimts.gestion_produit.exception.MarqueNotFoundException;
import bstorm.akimts.gestion_produit.models.dto.ProduitDTO;
import bstorm.akimts.gestion_produit.models.form.ProduitInsertForm;

import java.util.List;

public interface ProduitService {

    List<ProduitDTO> getAll();
    ProduitDTO getOne(long id);
    ProduitDTO insert(ProduitInsertForm form) throws MarqueNotFoundException;
    ProduitDTO delete(long id);

}
