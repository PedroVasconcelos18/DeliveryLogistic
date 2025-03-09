package br.com.pedrohvss.deliverylogistic.chainofresponsibility;

import br.com.pedrohvss.deliverylogistic.chainofresponsibility.handlers.InsuranceHandler;
import br.com.pedrohvss.deliverylogistic.chainofresponsibility.handlers.PromotionHandler;
import br.com.pedrohvss.deliverylogistic.chainofresponsibility.handlers.WeightHandler;

public class PriceHandlerChain {

    public static PriceHandler buildChain() {
        PriceHandler weightHandler = new WeightHandler();
        PriceHandler insuranceHandler = new InsuranceHandler();
        PriceHandler promotionHandler = new PromotionHandler();

        weightHandler.setNextHandler(insuranceHandler);
        insuranceHandler.setNextHandler(promotionHandler);

        return weightHandler;
    }

}
