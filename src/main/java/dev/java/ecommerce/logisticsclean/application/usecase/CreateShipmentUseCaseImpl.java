package dev.java.ecommerce.logisticsclean.application.usecase;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.CreateShipmentUseCase;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import org.springframework.stereotype.Service;

//It's the "implementation" of the use case defined in the domain.
// It depends inward on the domain's interfaces (like ShipmentRepository) but knows nothing about the database itself.
@Service
public class CreateShipmentUseCaseImpl implements CreateShipmentUseCase {

    private final ShipmentRepository shipmentRepository;

    public CreateShipmentUseCaseImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment create(Shipment shipment) {
        // Business rule: When creating a new shipment, its status should be set to "PENDING".
        shipment.setStatus("PENDING");
        return shipmentRepository.save(shipment);
    }


}
