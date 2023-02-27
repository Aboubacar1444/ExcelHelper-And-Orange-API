package spring.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy ="client", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    private List<LigneFacture> factures;


}
