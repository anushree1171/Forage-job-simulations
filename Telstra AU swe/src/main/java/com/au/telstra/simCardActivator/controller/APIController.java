package com.au.telstra.simCardActivator.controller;

import com.au.telstra.simCardActivator.dto.SIMCardDto;
import com.au.telstra.simCardActivator.entity.SIMCard;
import com.au.telstra.simCardActivator.service.SIMCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    SIMCardService simCardService;

    @PostMapping("/save")
    public void saveSIMCard(@RequestBody SIMCard simCard){
        simCardService.saveSimCard(simCard);
        simCardService.postToActivate(simCard);
    }

    @GetMapping("/getById/{id}")
    public SIMCardDto getSIMById(@PathVariable("id") int id){
        SIMCard sim = simCardService.getSimById(id);

        return SIMCardDto.builder()
                .id(sim.getId())
                .iccid(sim.getIccid())
                .customer_email(sim.getCustomer_email())
                .status(sim.getStatus())
                .build();
    }

    @GetMapping("/get")
    public List<SIMCard> getAllSimCards(){
        return simCardService.getAllSims();
    }

    @PutMapping("/put")
    public void updateSimCard(@RequestBody SIMCard simCard){
        simCardService.updateSim(simCard);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSIMCard(@PathVariable("id") int id){
        simCardService.deleteSim(id);
    }
}
