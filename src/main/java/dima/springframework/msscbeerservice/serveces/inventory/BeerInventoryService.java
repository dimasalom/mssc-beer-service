package dima.springframework.msscbeerservice.serveces.inventory;

import java.util.UUID;

public interface BeerInventoryService {

    Integer getOnHandInventory(UUID id);
}
