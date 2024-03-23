package com.au.telstra.simCardActivator.service;

import com.au.telstra.simCardActivator.entity.Actuation;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ActuationService {

    public String saveActuation(Actuation ac) throws JsonProcessingException;

}
