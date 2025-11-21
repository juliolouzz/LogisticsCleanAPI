CREATE TABLE shipments (
    id BIGSERIAL PRIMARY KEY,
    order_id VARCHAR(255) NOT NULL,
    origin VARCHAR(255),
    destination VARCHAR(255),
    status VARCHAR(255),
    estimated_delivery DATE
);
