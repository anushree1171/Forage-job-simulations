package com.au.telstra.simCardActivator.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class SIMCardDto {

    int id;

    String iccid;

    String customer_email;

    String status;
}
