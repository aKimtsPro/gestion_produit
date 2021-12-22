package bstorm.akimts.gestion_produit.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="marque")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

}
