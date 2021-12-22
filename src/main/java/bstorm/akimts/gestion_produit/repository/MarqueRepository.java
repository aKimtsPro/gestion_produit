package bstorm.akimts.gestion_produit.repository;

import bstorm.akimts.gestion_produit.models.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
}
