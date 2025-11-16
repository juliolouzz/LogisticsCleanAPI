package dev.java.ecommerce.logisticsclean.domain.entity;

import java.time.LocalDate;

public class Shipment {
    private Long id;
    private String orderId;
    private String origin;
    private String destination;
    private String status;
    private LocalDate estimatedDelivery;

    //First Constructor (with id and status): This is used when we are re-creating a Shipment object that already exists in the database.
    // When we fetch data, we know its id and status.
    public Shipment(Long id, String orderId, String origin, String destination, String status, LocalDate estimatedDelivery) {
        this.id = id;
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.estimatedDelivery = estimatedDelivery;
    }

    //Second Constructor (without id and status): This is used when we are creating a brand-new Shipment object for the first time (like from an API request).
    // At that moment, we don't have an id (the database will create it) and we don't have a status (the use case will set it to "PENDING").
    public Shipment(String orderId, String origin, String destination, LocalDate estimatedDelivery) {
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.estimatedDelivery = estimatedDelivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
}
