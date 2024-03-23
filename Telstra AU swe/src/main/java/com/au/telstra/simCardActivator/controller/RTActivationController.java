package com.au.telstra.simCardActivator.controller;

import com.au.telstra.simCardActivator.dto.SIMCardDto;
import com.au.telstra.simCardActivator.entity.SIMCard;
import com.au.telstra.simCardActivator.service.RTActivationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//restTemplateController

@RestController
@RequestMapping("/activate")
public class RTActivationController {

    @Autowired
    RTActivationService activationService;

    @PostMapping("/")
    public void activate(@RequestBody SIMCardDto simCard) throws JsonProcessingException {
//        SIMCardDto simCardDto = new SIMCardDto(simCard.getIccid(), simCard.getCustomer_email());
//        System.out.println(simCardDto);

        activationService.postToActuate(simCard);
    }

}
