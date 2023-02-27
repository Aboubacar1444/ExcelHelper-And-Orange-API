package spring.training.entity;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class FactureKey implements Serializable {

    @Serial
    private static final long serialVersionUID = -8374017816278521187L;

    private Integer factureId;

    private Integer productId;

}
