package org.juniorcodebreakers;

import org.juniorcodebreakers.model.Bike;
import org.juniorcodebreakers.model.Status;
import org.juniorcodebreakers.service.bike.BikeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = BikeRepository.class)
public class Main {
    //@Autowired
   // public BikeRepository bikeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Bike bike = new Bike(Status.STOLEN);
        Bike bike2 = new Bike(Status.AVAILABLE);
    }
}
