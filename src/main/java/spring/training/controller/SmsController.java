package spring.training.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.training.dto.SentSmsRequest;
import spring.training.dto.SmsResponse;

import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping("sms")
public class SmsController {

    @PostMapping
    public ResponseEntity<?> getAccessToken() {
        //Getting my SMS sending token
        String url = "https://api.orange.com/oauth/v3/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //Setting my headers
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic OUVvMkFjUXAxYmxKTU9oSUtmSjkxbWdFanpTMUtTU2g6QVI1Y1hIQXBKVkFZUFM0Tw==");
        //Setting my bodyParameters
        LinkedMultiValueMap bodyParamaters = new LinkedMultiValueMap<>();
        bodyParamaters.add("grant_type", "client_credentials");

        //Initializing my httpEntity for sending data
        HttpEntity<Object> entity = new HttpEntity<>(bodyParamaters, headers);

        //Exchange with Orange API to get my Token who has 3600 sec (1H) as durability
        ResponseEntity<SmsResponse> r = restTemplate.exchange(url, HttpMethod.POST, entity, SmsResponse.class);
        //Sending SMS process
        return ResponseEntity.ok().body(new SmsResponse(Objects.requireNonNull(r.getBody()).getAccess_token()));

    }

    @PostMapping(value = "/sent/{accessToken}")
    public ResponseEntity<?> sendSms(@RequestBody SentSmsRequest sms, @PathVariable String accessToken) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + accessToken);

        JSONObject message = new JSONObject();
        message.put("message", sms.getMessage());

        JSONObject t = new JSONObject();
        t.put("address", sms.getAddress());
        t.put("senderAddress", sms.getSenderAddress());
        t.put("outboundSMSTextMessage", message);

        JSONObject central = new JSONObject();


        central.put("outboundSMSMessageRequest", t);


        String sentSmsUrl = "https://api.orange.com/smsmessaging/v1/outbound/"+sms.getSenderAddress()+"/requests";

        HttpEntity<Object> entity = new HttpEntity<>(central.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        //Exchange with Orange API to get my Token who has 3600 sec (1H) as durability
        ResponseEntity<Object> r = restTemplate.exchange(sentSmsUrl, HttpMethod.POST, entity, Object.class);
        //Sending SMS process
        return ResponseEntity.ok().body(central.toString());

    }
}
