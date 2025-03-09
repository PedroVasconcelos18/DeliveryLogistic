package br.com.pedrohvss.deliverylogistic.dto;

import br.com.pedrohvss.deliverylogistic.enums.DeliveryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequestDTO {

    private DeliveryTypeEnum deliveryType = DeliveryTypeEnum.DEFAULT;
    private Boolean promotionCode;
    private String emailClient;
    private Boolean hasInsurance;
    private BigDecimal weight;

}
