package br.com.pedrohvss.deliverylogistic.chainofresponsibility.handlers;

import br.com.pedrohvss.deliverylogistic.chainofresponsibility.PriceHandler;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;
import br.com.pedrohvss.deliverylogistic.utils.RulesUtils;

import java.math.BigDecimal;

public class InsuranceHandler implements PriceHandler {
    private PriceHandler nextHandler;

    @Override
    public void setNextHandler(PriceHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public BigDecimal handle(DeliveryRequestDTO deliveryRequestDTO, BigDecimal price) {
        if (deliveryRequestDTO.getHasInsurance()) {
            price = new BigDecimal(RulesUtils.PROMOTION_DISCOUNT);
        }
        return nextHandler != null ? nextHandler.handle(deliveryRequestDTO, price) : price;
    }
}
