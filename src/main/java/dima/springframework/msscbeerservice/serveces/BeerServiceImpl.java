package dima.springframework.msscbeerservice.serveces;

import dima.springframework.msscbeerservice.domain.Beer;
import dima.springframework.msscbeerservice.repositories.BeerRepository;
import dima.springframework.msscbeerservice.web.controller.NotFoundException;
import dima.springframework.msscbeerservice.web.mappers.BeerMapper;
import dima.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("beerService")
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository repository;

    public final BeerMapper mapper;

    @Override
    public BeerDto getById(UUID id) {
        return mapper.beerToBeerDto(repository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return mapper.beerToBeerDto(repository.save(mapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID id, BeerDto beerDto) {
        Beer beer = repository.findById(id).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return mapper.beerToBeerDto(repository.save(beer));
    }
}
