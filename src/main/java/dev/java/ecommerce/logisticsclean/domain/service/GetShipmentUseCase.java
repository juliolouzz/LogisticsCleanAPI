package dev.java.ecommerce.logisticsclean.domain.service;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

import java.util.Optional;

public interface GetShipmentUseCase {
    Optional<Shipment> getShipment(Long id);
}
