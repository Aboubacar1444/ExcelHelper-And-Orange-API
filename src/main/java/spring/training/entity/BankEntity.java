package spring.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankEntity {
    private final Date createdAt = new Date();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    private String type;
    private Double iduserSama;
    private Double phoneUser;
    private String phoneReceiver;
    private Double mnoid;
    private String banque;
    private String idtranssama;
    private Double idTransBanque;
    private String transfertAt;
    private String serviceName;
    private String entryType;
    private Double montant;
    private Double postBalance;
    private Double frais;
    private Double imei;
    private LocalDateTime saveAt;
    private String erreur;
    private Double status;
    private String mVersClientSama;
    private String aVersClient;


}