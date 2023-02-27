package spring.training.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BankDto implements Serializable {
    private final String type;
    private final String iduserSama;
    private final String phoneUser;
    private final String phoneReceiver;
    private final double mnoid;
    private final String banque;
    private final String idtranssama;
    private final String idTransBanque;
    private final Date transfertAt;
    private final String serviceName;
    private final String entryType;
    private final double montant;
    private final double postBalance;
    private final double frais;
    private final String imei;
    private final Date saveAt;
    private final String erreur;
    private final boolean status;
    private final String mVersClientSama;
    private final String aVersClient;


}
