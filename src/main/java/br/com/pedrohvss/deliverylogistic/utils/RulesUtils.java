package br.com.pedrohvss.deliverylogistic.utils;

import br.com.pedrohvss.deliverylogistic.chainofresponsibility.PriceHandler;
import br.com.pedrohvss.deliverylogistic.chainofresponsibility.PriceHandlerChain;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RulesUtils {

    public static final String PROMOTION_DISCOUNT = "13.50";

    public static BigDecimal getPrice(DeliveryRequestDTO deliveryRequestDTO) {
        BigDecimal price = generateRandomBigDecimal();

        PriceHandler chain = PriceHandlerChain.buildChain();

        price = chain.handle(deliveryRequestDTO, price);

        return price.setScale(2, RoundingMode.HALF_DOWN);

    }

    private static BigDecimal generateRandomBigDecimal() {
        Random random = new Random();
        BigDecimal max = BigDecimal.valueOf(50L);
        double randomDouble = random.nextDouble();

        BigDecimal range = max.subtract(BigDecimal.TEN);
        BigDecimal randomInRange = BigDecimal.TEN.add(range.multiply(BigDecimal.valueOf(randomDouble)));

        return randomInRange.setScale(2, RoundingMode.HALF_UP);
    }

}
