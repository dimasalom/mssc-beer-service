package dima.springframework.msscbeerservice.bootstrap;

import dima.springframework.msscbeerservice.domain.Beer;
import dima.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_UPC_1 = "156321789654";
    public static final String BEER_UPC_2 = "256321789654";
    public static final String BEER_UPC_3 = "356321789654";

    private final BeerRepository repository;

    public BeerLoader(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();

    }

    private void loadBeer() {

        if (repository.count() == 0) {

            repository.save(Beer.builder()
                    .beerName("Carsberg")
                    .beerStyle("Wagen")
                    .quantityToBelow(200)
                    .upc(BEER_UPC_1)
                    .price(new BigDecimal("34.65"))
                    .minOnHand(12)
                    .build());

            repository.save(Beer.builder()
                    .beerName("Staropramen")
                    .beerStyle("Obolon")
                    .quantityToBelow(150)
                    .upc(BEER_UPC_2)
                    .price(new BigDecimal("30.65"))
                    .minOnHand(40)
                    .build());

            repository.save(Beer.builder()
                    .beerName("Staropramen")
                    .beerStyle("Carsberg")
                    .quantityToBelow(150)
                    .upc(BEER_UPC_3)
                    .price(new BigDecimal("30.65"))
                    .minOnHand(40)
                    .build());
        }

        System.out.println("Beers loaded: " + repository.count() + " pcs");
    }
}
