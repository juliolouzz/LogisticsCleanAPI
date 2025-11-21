package dev.java.ecommerce.logisticsclean.application.usecase;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import dev.java.ecommerce.logisticsclean.domain.service.UpdateShipmentUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateShipmentUseCaseImpl implements UpdateShipmentUseCase {

    private final ShipmentRepository shipmentRepository;

    public UpdateShipmentUseCaseImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment update(Long id, Shipment shipment) {
        return shipmentRepository.findById(id)
                .map(existingShipment -> {
                    // Update fields
                    existingShipment.setOrderId(shipment.getOrderId());
                    existingShipment.setOrigin(shipment.getOrigin());
                    existingShipment.setDestination(shipment.getDestination());
                    existingShipment.setEstimatedDelivery(shipment.getEstimatedDelivery());
                    // Note: Status might have specific transition rules, but for simple update we
                    // allow it.
                    // Ideally, status changes should be separate use cases if they have complex
                    // logic.
                    if (shipment.getStatus() != null) {
                        existingShipment.setStatus(shipment.getStatus());
                    }
                    return shipmentRepository.save(existingShipment);
                })
                .orElseThrow(() -> new RuntimeException("Shipment not found with id: " + id));
    }
}
