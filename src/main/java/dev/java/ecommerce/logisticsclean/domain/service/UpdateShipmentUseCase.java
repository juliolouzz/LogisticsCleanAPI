package dev.java.ecommerce.logisticsclean.domain.service;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

public interface UpdateShipmentUseCase {
    Shipment update(Long id, Shipment shipment);
}
