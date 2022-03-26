package dima.springframework.msscbeerservice.bootstrap;

import dima.springframework.msscbeerservice.domain.Beer;
import dima.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_UPC_1 = "0631234200036";
    public static final String BEER_UPC_2 = "0631234300019";
    public static final String BEER_UPC_3 = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    public static final UUID id = UUID.randomUUID();


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
                    .beerStyle("WAGEN")
                    .quantityToBrew(200)
                    .upc(BEER_UPC_1)
                    .price(new BigDecimal("34.65"))
                    .minOnHand(12)
                    .build());

            repository.save(Beer.builder()
                    .beerName("Staropramen")
                    .beerStyle("LAGER")
                    .quantityToBrew(150)
                    .upc(BEER_UPC_2)
                    .price(new BigDecimal("30.65"))
                    .minOnHand(40)
                    .build());

            repository.save(Beer.builder()
                    .beerName("Staropramen")
                    .beerStyle("ALE")
                    .quantityToBrew(150)
                    .upc(BEER_UPC_3)
                    .price(new BigDecimal("30.65"))
                    .minOnHand(40)
                    .build());
        }

        System.out.println("Beers loaded: " + repository.count() + " pcs. " + id);
    }
}
