package br.com.carstore.carstore.runner;

import br.com.carstore.carstore.dao.CarJpaDAO;
import br.com.carstore.carstore.model.CarDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CarJpaDAO car;

    public StartupRunner(CarJpaDAO Car) {

        this.car = Car;

    }

    @Override
    public void run(String... args) throws Exception {
        car.save(new CarDTO("camaro", "amarelo"));
        car.save(new CarDTO("subaru", "preto"));
        car.save((new CarDTO("volkswagen","banco")));
        System.out.println(car.findAll());
    }
}