package dima.springframework.msscbeerservice.serveces;

import dima.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID id);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID id, BeerDto beerDto);
}
