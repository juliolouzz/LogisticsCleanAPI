package dev.java.ecommerce.logisticsclean.infrastructure.web;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.CreateShipmentUseCase;
import dev.java.ecommerce.logisticsclean.infrastructure.web.dto.ShipmentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final CreateShipmentUseCase createShipmentUseCase;
    private final dev.java.ecommerce.logisticsclean.domain.service.GetShipmentUseCase getShipmentUseCase;
    private final dev.java.ecommerce.logisticsclean.domain.service.GetAllShipmentsUseCase getAllShipmentsUseCase;
    private final dev.java.ecommerce.logisticsclean.domain.service.UpdateShipmentUseCase updateShipmentUseCase;
    private final dev.java.ecommerce.logisticsclean.domain.service.DeleteShipmentUseCase deleteShipmentUseCase;

    public ShipmentController(CreateShipmentUseCase createShipmentUseCase,
            dev.java.ecommerce.logisticsclean.domain.service.GetShipmentUseCase getShipmentUseCase,
            dev.java.ecommerce.logisticsclean.domain.service.GetAllShipmentsUseCase getAllShipmentsUseCase,
            dev.java.ecommerce.logisticsclean.domain.service.UpdateShipmentUseCase updateShipmentUseCase,
            dev.java.ecommerce.logisticsclean.domain.service.DeleteShipmentUseCase deleteShipmentUseCase) {
        this.createShipmentUseCase = createShipmentUseCase;
        this.getShipmentUseCase = getShipmentUseCase;
        this.getAllShipmentsUseCase = getAllShipmentsUseCase;
        this.updateShipmentUseCase = updateShipmentUseCase;
        this.deleteShipmentUseCase = deleteShipmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Shipment> create(@RequestBody ShipmentDTO shipmentDTO) {
        Shipment shipment = shipmentDTO.toDomain();
        Shipment createdShipment = createShipmentUseCase.create(shipment);
        return new ResponseEntity<>(createdShipment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getById(@PathVariable Long id) {
        return getShipmentUseCase.getShipment(id)
                .map(shipment -> new ResponseEntity<>(shipment, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<java.util.List<Shipment>> getAll() {
        return new ResponseEntity<>(getAllShipmentsUseCase.getAllShipments(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> update(@PathVariable Long id, @RequestBody ShipmentDTO shipmentDTO) {
        try {
            Shipment shipment = shipmentDTO.toDomain();
            Shipment updatedShipment = updateShipmentUseCase.update(id, shipment);
            return new ResponseEntity<>(updatedShipment, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteShipmentUseCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
