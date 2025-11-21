# LogisticsClean API

A Clean Architecture implementation for a Logistics API, built with Spring Boot.

## Overview

This project demonstrates the implementation of Clean Architecture principles in a Java Spring Boot application. It separates the core business logic (Domain) from external concerns (Infrastructure) using layers and dependency inversion.

### Architecture Layers

1.  **Domain Layer**: Contains the core business logic and entities. It has no dependencies on frameworks or external libraries.
    *   `entity`: Core business objects (`Shipment`).
    *   `service`: Interfaces defining use cases (`CreateShipmentUseCase`) and output ports (`ShipmentRepository`).
2.  **Application Layer**: Implements the use cases defined in the domain.
    *   `usecase`: Implementation of business rules (`CreateShipmentUseCaseImpl`).
3.  **Infrastructure Layer**: Adapters for external systems (Web, Database, Configuration).
    *   `web`: REST Controllers and DTOs (`ShipmentController`, `ShipmentDTO`).
    *   `persistence`: Database adapters using Spring Data JPA (`JpaShipmentRepository`, `ShipmentEntity`).
    *   `config`: Spring configuration beans (`BeanConfiguration`).

## Prerequisites

*   Java 17+
*   Docker & Docker Compose
*   Maven (wrapper included)

## Dependencies

*   **Spring Boot Starter Data JPA**: For database interactions.
*   **Spring Boot Starter Web**: For building the REST API.
*   **Flyway Core & PostgreSQL**: For database migration and PostgreSQL support.
*   **PostgreSQL Driver**: Runtime dependency for PostgreSQL.
*   **Lombok**: To reduce boilerplate code.
*   **Spring Boot Starter Test**: For testing support.
*   **H2 Database**: For in-memory database testing.

## Getting Started

### 1. Start the Database

Use Docker Compose to start the PostgreSQL database:

```bash
docker-compose up -d
```

This will start a PostgreSQL container listening on port `5431`.

### 2. Run the Application

You can run the application using the Maven wrapper. The application is configured to connect to the local Docker database by default.

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

### 3. API Endpoints (CRUD)

The following endpoints are available for managing shipments:

*   **Create Shipment**: `POST /shipments`
    ```json
    {
      "orderId": "ORD-123",
      "origin": "New York",
      "destination": "Los Angeles",
      "estimatedDelivery": "2023-12-31"
    }
    ```
*   **Get Shipment**: `GET /shipments/{id}`
*   **List Shipments**: `GET /shipments`
*   **Update Shipment**: `PUT /shipments/{id}`
    ```json
    {
      "orderId": "ORD-123",
      "origin": "New York",
      "destination": "San Francisco",
      "estimatedDelivery": "2024-01-01",
      "status": "SHIPPED"
    }
    ```
*   **Delete Shipment**: `DELETE /shipments/{id}`

### 4. Run Tests

The project uses an in-memory H2 database for testing, so tests run independently of the Docker container.

```bash
./mvnw clean test
```

## Database Connection (DBeaver/pgAdmin)

To connect to the database manually:

*   **Host**: `localhost`
*   **Port**: `5431`
*   **Database**: `logistics_db`
*   **Username**: `postgres`
*   **Password**: `postgres`
