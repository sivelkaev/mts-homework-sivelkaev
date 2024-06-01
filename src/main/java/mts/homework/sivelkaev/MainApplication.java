package mts.homework.sivelkaev;

import mts.homework.sivelkaev.service.CreateAnimalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(MainApplication.class, args);
        var service = ctx.getBean(CreateAnimalService.class);
        service.createAnimalGroup();
    }
}
