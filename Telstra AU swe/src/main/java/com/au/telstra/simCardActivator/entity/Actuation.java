package com.au.telstra.simCardActivator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ActuationDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Actuation {

    @Id
    String iccid;

    Boolean success;
}
