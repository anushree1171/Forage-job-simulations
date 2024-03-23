package com.au.telstra.simCardActivator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ActuationDto {

    String iccid;

    Boolean success;
}
