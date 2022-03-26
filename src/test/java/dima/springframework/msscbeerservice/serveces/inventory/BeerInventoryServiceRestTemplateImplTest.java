package dima.springframework.msscbeerservice.serveces.inventory;

import dima.springframework.msscbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getOnHandInventory() {
        Integer quantityOnHand = service.getOnHandInventory(BeerLoader.BEER_1_UUID);

        System.out.println(quantityOnHand);
    }

    @Test
    void getListOfBeers() {

    }
}