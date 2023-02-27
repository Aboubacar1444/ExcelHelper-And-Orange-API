package spring.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SentSmsRequest implements Serializable {
    private String address;
    private String senderAddress;
    private String message;


}
