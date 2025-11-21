package dev.java.ecommerce.logisticsclean.infrastructure.persistence;

import dev.java.ecommerce.logisticsclean.infrastructure.persistence.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataShipmentRepository extends JpaRepository<ShipmentEntity, Long> {
    Optional<ShipmentEntity> findByOrderId(String orderId);
}
