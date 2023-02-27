
package spring.training.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date importedAt = new Date();
    private String matricule ;
    private String numAttestation ;
    private String lycee ;
    private String nom ;
    private String prenom ;
    private String sexe ;
    private String dateNaissance ;
    private String dateNaissanceCenou ;
    private String lieuNaissance ;
    private String pays_naiss ;
    private String nationalite ;
    private String phone ;
    private String nompere ;
    private String prenompere ;
    private String nommere ;
    private String prenommere ;
    private String matriculeDEF ;
    private String anneeBac ;
    private String serie ;
    private String numPlace ;
    private String statut ;
    private String centreBac ;
    private String ae ;
    private String adresseparent ;
    private String phone1 ;
    private String etablissement;
    private String idBanq;
    private String scolarite;
    private String bacMention;
    private String moyenneEcrit;
    private String moyenneAnuelle;
    private String moyenneAdmission;
    private String anneeNaissance;
    private String anneeDEF;
    private String scolariteNew;
    private String scolariteNew2;
    private String age ;
    private String inscriptibiliteAge;
    private String inscriptibiliteNationale;
    private String inscriptibiliteGenerale;
    
    
}
