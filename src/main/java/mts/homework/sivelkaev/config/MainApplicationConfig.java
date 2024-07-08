package mts.homework.sivelkaev.config;

import mts.homework.sivelkaev.old.service_old.CreateAnimalService;
import mts.homework.sivelkaev.old.service_old.impl.CreateAnimalServiceImpl;
import mts.homework.starter.config.NameProperties;
import mts.homework.starter.service.AnimalService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class MainApplicationConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean()
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl(animalService());
    }

    @Bean()
    @Scope("prototype")
    public AnimalService animalService() {
        return new AnimalService(nameProperties());
    }

    @Bean()
    @Scope("prototype")
    public NameProperties nameProperties() {
        return new NameProperties();
    }
}