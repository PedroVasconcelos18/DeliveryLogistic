package br.com.pedrohvss.deliverylogistic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeliveryTypeEnum {

    DEFAULT("5-7"),
    EXPRESS("2-3"),
    SAME_DAY("1"),
    INTERNATIONAL("7-15");

    private final String days;

}
