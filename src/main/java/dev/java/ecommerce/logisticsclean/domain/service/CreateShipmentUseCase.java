package dev.java.ecommerce.logisticsclean.domain.service;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

// The application needs some way to execute the business rule of creating a shipment.
public interface CreateShipmentUseCase {
    Shipment create(Shipment shipment);
}
