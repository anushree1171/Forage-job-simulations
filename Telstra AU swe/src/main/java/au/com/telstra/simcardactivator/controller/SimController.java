package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.entity.SIMCardDetailsRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class SimController {

    private final String ACTUATOR_URL = "http://localhost:8444/actuate";

    @PostMapping("/activate")
    public ResponseEntity<String> activateSIM(@RequestBody SIMCardDetailsRequest request){
        String iccid = request.getIccid();
        String email = request.getCustomer_email();



        //Having received the details through the response
        //Preparing the icc id json to be sent via the actuator
        String requestBody = "{\"iccid\": \"" + iccid + "\"}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, httpHeaders);


        //Making the post request to the actuator
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                ACTUATOR_URL,
                HttpMethod.POST,
                httpEntity,
                String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            // Process the response from the actuator
            return ResponseEntity.ok(responseBody);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to activate SIM");
        }

    }

}
