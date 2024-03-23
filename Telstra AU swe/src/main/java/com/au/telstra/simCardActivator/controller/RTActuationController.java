package com.au.telstra.simCardActivator.controller;


import com.au.telstra.simCardActivator.entity.Actuation;
import com.au.telstra.simCardActivator.entity.SIMCard;
import com.au.telstra.simCardActivator.service.ActuationService;
import com.au.telstra.simCardActivator.service.SIMCardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//restTemplateController
@RestController
@RequestMapping("/actuate")
public class RTActuationController {

    @Autowired
    ActuationService actuationService;

    @Autowired
    SIMCardService simCardService;

    @PostMapping("/")
    public String Actuate(@RequestBody SIMCard simCard) throws JsonProcessingException {
        System.out.println("Actuation Controller:");
        System.out.println(simCard);


        if(simCard.getIccid()!=null){
            simCard.setStatus("active");
            simCardService.saveSimCard(simCard);
        }
        else{
            simCard.setStatus(null);
            simCardService.saveSimCard(simCard);
        }

        Actuation ac = new Actuation();
        ac.setIccid(simCard.getIccid());

        System.out.println(ac);

        return actuationService.saveActuation(ac);

    }



}
