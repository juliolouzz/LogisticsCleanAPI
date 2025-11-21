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
}
