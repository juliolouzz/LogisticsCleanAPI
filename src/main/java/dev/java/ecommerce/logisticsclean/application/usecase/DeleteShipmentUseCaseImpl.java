package dev.java.ecommerce.logisticsclean.application.usecase;

import dev.java.ecommerce.logisticsclean.domain.service.DeleteShipmentUseCase;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteShipmentUseCaseImpl implements DeleteShipmentUseCase {

    private final ShipmentRepository shipmentRepository;

    public DeleteShipmentUseCaseImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public void delete(Long id) {
        shipmentRepository.deleteById(id);
    }
}
