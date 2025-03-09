package br.com.pedrohvss.deliverylogistic.chainofresponsibility;

import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;

import java.math.BigDecimal;

public interface PriceHandler {

    void setNextHandler(PriceHandler nextHandler);

    BigDecimal handle(DeliveryRequestDTO deliveryRequestDTO, BigDecimal price);

}
