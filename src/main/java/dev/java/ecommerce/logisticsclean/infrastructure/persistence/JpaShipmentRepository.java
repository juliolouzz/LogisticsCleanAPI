package dev.java.ecommerce.logisticsclean.infrastructure.persistence;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import dev.java.ecommerce.logisticsclean.infrastructure.persistence.entity.ShipmentEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaShipmentRepository implements ShipmentRepository {

    private final SpringDataShipmentRepository springDataShipmentRepository;

    public JpaShipmentRepository(SpringDataShipmentRepository springDataShipmentRepository) {
        this.springDataShipmentRepository = springDataShipmentRepository;
    }

    @Override
    public Shipment save(Shipment shipment) {
        ShipmentEntity entity = toEntity(shipment);
        ShipmentEntity savedEntity = springDataShipmentRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Shipment> findById(Long id) {
        return springDataShipmentRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Shipment> findByOrderId(String orderId) {
        return springDataShipmentRepository.findByOrderId(orderId).map(this::toDomain);
    }

    private ShipmentEntity toEntity(Shipment shipment) {
        return new ShipmentEntity(
                shipment.getId(),
                shipment.getOrderId(),
                shipment.getOrigin(),
                shipment.getDestination(),
                shipment.getStatus(),
                shipment.getEstimatedDelivery());
    }

    private Shipment toDomain(ShipmentEntity entity) {
        return new Shipment(
                entity.getId(),
                entity.getOrderId(),
                entity.getOrigin(),
                entity.getDestination(),
                entity.getStatus(),
                entity.getEstimatedDelivery());
    }
}
