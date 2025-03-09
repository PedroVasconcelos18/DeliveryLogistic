package br.com.pedrohvss.deliverylogistic.chainofresponsibility.handlers;

import br.com.pedrohvss.deliverylogistic.chainofresponsibility.PriceHandler;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;

import java.math.BigDecimal;

public class PromotionHandler implements PriceHandler {
    private PriceHandler nextHandler;

    @Override
    public void setNextHandler(PriceHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public BigDecimal handle(DeliveryRequestDTO deliveryRequestDTO, BigDecimal price) {
        if (deliveryRequestDTO.getPromotionCode()) {
            price = price.min(BigDecimal.TEN);
        }
        return nextHandler != null ? nextHandler.handle(deliveryRequestDTO, price) : price;
    }
}
