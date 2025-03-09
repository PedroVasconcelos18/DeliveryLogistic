package br.com.pedrohvss.deliverylogistic.service;

import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryResponseDTO;
import br.com.pedrohvss.deliverylogistic.service.impl.DeliveryService;
import br.com.pedrohvss.deliverylogistic.strategy.DeliveryStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final List<DeliveryStrategy> deliveryStrategy;

    public DeliveryServiceImpl(List<DeliveryStrategy> deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    @Override
    public DeliveryResponseDTO getDeliveryResponse(DeliveryRequestDTO deliveryRequestDTO) {

        return deliveryStrategy.stream()
                .filter(x -> x.supports(deliveryRequestDTO.getDeliveryType()))
                .findFirst()
                .map(strategy -> strategy.execute(deliveryRequestDTO))
                .orElse(null);

    }

}
