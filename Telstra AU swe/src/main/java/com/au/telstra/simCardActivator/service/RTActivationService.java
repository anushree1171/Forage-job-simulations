package com.au.telstra.simCardActivator.service;

import com.au.telstra.simCardActivator.dto.SIMCardDto;
import com.au.telstra.simCardActivator.entity.SIMCard;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RTActivationService {

    RestTemplate restTemplate;

    private final String actuationUrl;

    public RTActivationService(){
        this.restTemplate = new RestTemplate();
        //this.actuationUrl = "http://localhost:8444/actuate/";
        this.actuationUrl = "http://localhost:8080/actuate/";
    }

    public void postToActuate(SIMCardDto simCard){
        SIMCard simCard1 = SIMCard.builder()
                .iccid(simCard.getIccid())
                .customer_email(simCard.getCustomer_email())
                .status(simCard.getStatus())
                .build();
        ResponseEntity<String> response = restTemplate.postForEntity(actuationUrl, simCard1, String.class);

        System.out.println("Activation Service:");
        System.out.println(response);
    }
}
