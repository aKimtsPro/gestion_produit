package bstorm.akimts.gestion_produit.utils;

import bstorm.akimts.gestion_produit.models.entities.Marque;
import bstorm.akimts.gestion_produit.models.entities.Produit;
import bstorm.akimts.gestion_produit.models.entities.User;
import bstorm.akimts.gestion_produit.repository.MarqueRepository;
import bstorm.akimts.gestion_produit.repository.ProduitRepository;
import bstorm.akimts.gestion_produit.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFiller implements InitializingBean {

    private final ProduitRepository produitRepository;
    private final MarqueRepository marqueRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public DatabaseFiller(ProduitRepository produitRepository, MarqueRepository marqueRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.produitRepository = produitRepository;
        this.marqueRepository = marqueRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        Marque m1 = new Marque();
        m1.setNom( "marque 1" );
        m1 = marqueRepository.save( m1 );

        Marque m2 = new Marque();
        m2.setNom( "marque 2" );
        m2 = marqueRepository.save( m2 );

        Produit p1 = new Produit();
        p1.setNom("Patate");
        p1.setPrix(0.5);
        p1.setMarque( m1 );

        p1 = produitRepository.save(p1);

        Produit p2 = new Produit();
        p2.setNom("Chocolat");
        p2.setPrix(2.8);
        p2.setMarque( m1 );

        p2 = produitRepository.save(p2);

        Produit p3 = new Produit();
        p3.setNom("sofa");
        p3.setPrix(200);
        p3.setMarque( m2 );

        p3 = produitRepository.save(p3);

        User user = new User();
        user.setUsername("user");
        user.setPassword( encoder.encode("pass") );

        user = userRepository.save(user);

    }
}
