package bstorm.akimts.gestion_produit.repository;

import bstorm.akimts.gestion_produit.models.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
