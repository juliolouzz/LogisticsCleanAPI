package dev.java.ecommerce.logisticsclean.infrastructure.web.dto;

import dev.java.ecommerce.logisticsclean.domain.entity.Shipment;

import java.time.LocalDate;

public class ShipmentDTO {
    private String orderId;
    private String origin;
    private String destination;
    private LocalDate estimatedDelivery;

    private String status;

    public ShipmentDTO() {
    }

    public ShipmentDTO(String orderId, String origin, String destination, LocalDate estimatedDelivery, String status) {
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.estimatedDelivery = estimatedDelivery;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shipment toDomain() {
        Shipment shipment = new Shipment(orderId, origin, destination, estimatedDelivery);
        if (status != null) {
            shipment.setStatus(status);
        }
        return shipment;
    }
}
