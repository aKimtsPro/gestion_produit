package bstorm.akimts.gestion_produit.exception;

public class MarqueNotFoundException extends RuntimeException {

    private final long id;

    public MarqueNotFoundException(long id) {
        super("La marque d'id {"+ id + "} n'a pas été trouvée");
        this.id = id;
    }
}
