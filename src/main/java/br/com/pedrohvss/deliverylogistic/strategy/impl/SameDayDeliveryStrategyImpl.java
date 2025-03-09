package br.com.pedrohvss.deliverylogistic.strategy.impl;

import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryResponseDTO;
import br.com.pedrohvss.deliverylogistic.enums.DeliveryTypeEnum;
import br.com.pedrohvss.deliverylogistic.strategy.DeliveryStrategy;
import br.com.pedrohvss.deliverylogistic.utils.RulesUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SameDayDeliveryStrategyImpl implements DeliveryStrategy {
    @Override
    public boolean supports(DeliveryTypeEnum deliveryType) {
        return DeliveryTypeEnum.SAME_DAY.equals(deliveryType);
    }

    @Override
    public DeliveryResponseDTO execute(DeliveryRequestDTO deliveryRequestDTO) {

        BigDecimal price = RulesUtils.getPrice(deliveryRequestDTO);

        return DeliveryResponseDTO.builder()
                .daysToDelivery(DeliveryTypeEnum.SAME_DAY.getDays())
                .deliveryCost(price)
                .build();
    }
}
