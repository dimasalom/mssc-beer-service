package guru.springframework.msscbeerservice;

import guru.springframework.msscbeerservice.web.mappers.BeerMapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsscBeerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsscBeerServiceApplication.class, args);
    }
}
