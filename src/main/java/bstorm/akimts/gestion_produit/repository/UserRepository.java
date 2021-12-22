package bstorm.akimts.gestion_produit.repository;

import bstorm.akimts.gestion_produit.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
