package dev.java.ecommerce.logisticsclean.infrastructure.web;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.CreateShipmentUseCase;
import dev.java.ecommerce.logisticsclean.infrastructure.web.dto.ShipmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final CreateShipmentUseCase createShipmentUseCase;

    public ShipmentController(CreateShipmentUseCase createShipmentUseCase) {
        this.createShipmentUseCase = createShipmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Shipment> create(@RequestBody ShipmentDTO shipmentDTO) {
        Shipment createdShipment = createShipmentUseCase.create(shipmentDTO.toDomain());
        return ResponseEntity.ok(createdShipment);
    }
}
