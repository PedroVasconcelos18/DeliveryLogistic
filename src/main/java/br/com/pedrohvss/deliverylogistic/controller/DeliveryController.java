package br.com.pedrohvss.deliverylogistic.controller;


import br.com.pedrohvss.deliverylogistic.dto.DeliveryRequestDTO;
import br.com.pedrohvss.deliverylogistic.dto.DeliveryResponseDTO;
import br.com.pedrohvss.deliverylogistic.service.impl.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("${api.version}/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    private DeliveryResponseDTO deliveryRequest(@RequestBody DeliveryRequestDTO deliveryRequestDTO) {
        return deliveryService.getDeliveryResponse(deliveryRequestDTO);
    }

}
