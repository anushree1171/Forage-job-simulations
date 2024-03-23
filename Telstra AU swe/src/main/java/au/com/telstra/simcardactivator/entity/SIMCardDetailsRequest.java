package au.com.telstra.simcardactivator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SIMCardDetailsRequest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SIMCardDetailsRequest {

    @Column
    @Id
    String iccid;

    @Column
    String customer_email;
}
