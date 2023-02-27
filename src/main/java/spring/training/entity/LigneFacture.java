package spring.training.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@ToString
public class LigneFacture implements Serializable {

    @Serial
    private static long serialVersionUID = 711362394965803008L;

    @EmbeddedId
    private FactureKey factureKey;

    @ManyToOne
    @MapsId("factureId")
    private Facture facture;

    @ManyToOne
    @MapsId("productId")
    private Product product;
    @ManyToOne
    private Client client;
    private double quantite;
}
