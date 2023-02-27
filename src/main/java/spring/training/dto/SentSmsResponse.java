package spring.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SentSmsResponse implements Serializable {
    private String senderAddress;
    private String senderName;
}
