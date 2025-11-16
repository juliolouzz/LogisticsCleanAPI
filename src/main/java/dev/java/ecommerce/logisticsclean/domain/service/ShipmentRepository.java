package dev.java.ecommerce.logisticsclean.domain.service;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

import java.util.Optional;

// The domain needs some way to save and find shipments.
public interface ShipmentRepository {
    Shipment save(Shipment shipment);
    Optional<Shipment> findById(Long id);
    Optional<Shipment> findByOrderId(Long orderId);
}
