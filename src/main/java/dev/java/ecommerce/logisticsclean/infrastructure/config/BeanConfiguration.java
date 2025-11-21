package dev.java.ecommerce.logisticsclean.infrastructure.config;

import dev.java.ecommerce.logisticsclean.application.usecase.CreateShipmentUseCaseImpl;
import dev.java.ecommerce.logisticsclean.domain.service.CreateShipmentUseCase;
import dev.java.ecommerce.logisticsclean.domain.service.ShipmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateShipmentUseCase createShipmentUseCase(ShipmentRepository shipmentRepository) {
        return new CreateShipmentUseCaseImpl(shipmentRepository);
    }

    @Bean
    public dev.java.ecommerce.logisticsclean.domain.service.GetShipmentUseCase getShipmentUseCase(
            ShipmentRepository shipmentRepository) {
        return new dev.java.ecommerce.logisticsclean.application.usecase.GetShipmentUseCaseImpl(shipmentRepository);
    }

    @Bean
    public dev.java.ecommerce.logisticsclean.domain.service.GetAllShipmentsUseCase getAllShipmentsUseCase(
            ShipmentRepository shipmentRepository) {
        return new dev.java.ecommerce.logisticsclean.application.usecase.GetAllShipmentsUseCaseImpl(shipmentRepository);
    }

    @Bean
    public dev.java.ecommerce.logisticsclean.domain.service.UpdateShipmentUseCase updateShipmentUseCase(
            ShipmentRepository shipmentRepository) {
        return new dev.java.ecommerce.logisticsclean.application.usecase.UpdateShipmentUseCaseImpl(shipmentRepository);
    }

    @Bean
    public dev.java.ecommerce.logisticsclean.domain.service.DeleteShipmentUseCase deleteShipmentUseCase(
            ShipmentRepository shipmentRepository) {
        return new dev.java.ecommerce.logisticsclean.application.usecase.DeleteShipmentUseCaseImpl(shipmentRepository);
    }
}
