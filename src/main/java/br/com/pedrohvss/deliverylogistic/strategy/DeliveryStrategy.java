package br.com.pedrohvss.deliverylogistic.strategy;

import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryResponseDTO;
import br.com.pedrohvss.deliverylogistic.enums.DeliveryTypeEnum;

public interface DeliveryStrategy {

    boolean supports(DeliveryTypeEnum deliveryType);

    DeliveryResponseDTO execute(DeliveryRequestDTO deliveryRequestDTO);

}
