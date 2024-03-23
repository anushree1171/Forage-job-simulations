package com.au.telstra.simCardActivator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="SimCardDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SIMCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String iccid;

    String customer_email;

    String status; // initially null, for when the sim card has to be activated by the actuator
}
