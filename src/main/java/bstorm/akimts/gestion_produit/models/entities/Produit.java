package bstorm.akimts.gestion_produit.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "produit")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double prix;

    @ManyToOne
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;

}
