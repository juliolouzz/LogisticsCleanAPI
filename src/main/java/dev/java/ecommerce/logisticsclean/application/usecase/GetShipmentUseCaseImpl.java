package dev.java.ecommerce.logisticsclean.application.usecase;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.GetShipmentUseCase;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetShipmentUseCaseImpl implements GetShipmentUseCase {

    private final ShipmentRepository shipmentRepository;

    public GetShipmentUseCaseImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Optional<Shipment> getShipment(Long id) {
        return shipmentRepository.findById(id);
    }
}
