package dev.java.ecommerce.logisticsclean.infrastructure.web.dto;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

import java.time.LocalDate;

public class ShipmentDTO {
    private String orderId;
    private String origin;
    private String destination;
    private LocalDate estimatedDelivery;

    public ShipmentDTO() {
    }

    public ShipmentDTO(String orderId, String origin, String destination, LocalDate estimatedDelivery) {
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.estimatedDelivery = estimatedDelivery;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public Shipment toDomain() {
        return new Shipment(orderId, origin, destination, estimatedDelivery);
    }
}
