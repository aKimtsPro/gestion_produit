package bstorm.akimts.gestion_produit.service.spec;

import bstorm.akimts.gestion_produit.models.dto.MarqueDTO;
import bstorm.akimts.gestion_produit.models.entities.Marque;

import java.util.List;

public interface MarqueService {

    List<MarqueDTO> getAll();

}
