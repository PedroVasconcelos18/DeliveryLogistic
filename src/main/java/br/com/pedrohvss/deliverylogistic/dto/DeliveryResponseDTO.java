package br.com.pedrohvss.deliverylogistic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDTO {

    private String daysToDelivery;
    private BigDecimal deliveryCost;

}
