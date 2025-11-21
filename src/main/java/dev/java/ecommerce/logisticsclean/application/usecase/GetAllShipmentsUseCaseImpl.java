package dev.java.ecommerce.logisticsclean.application.usecase;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.GetAllShipmentsUseCase;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllShipmentsUseCaseImpl implements GetAllShipmentsUseCase {

    private final ShipmentRepository shipmentRepository;

    public GetAllShipmentsUseCaseImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
}
