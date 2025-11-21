package dev.java.ecommerce.logisticsclean.domain.service;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

import java.util.List;

public interface GetAllShipmentsUseCase {
    List<Shipment> getAllShipments();
}
