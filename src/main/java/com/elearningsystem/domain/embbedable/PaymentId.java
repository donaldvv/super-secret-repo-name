package com.elearningsystem.domain.embbedable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PaymentId {

    private Integer stdID;

    @Column(name = "checkNumber")
    private String checkNumber;
}
