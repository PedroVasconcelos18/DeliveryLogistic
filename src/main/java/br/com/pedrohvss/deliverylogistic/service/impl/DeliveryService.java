package br.com.pedrohvss.deliverylogistic.service.impl;

import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryResponseDTO;

public interface DeliveryService {

    DeliveryResponseDTO getDeliveryResponse(DeliveryRequestDTO deliveryRequestDTO);

}
