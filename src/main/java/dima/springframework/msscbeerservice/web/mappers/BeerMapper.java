package dima.springframework.msscbeerservice.web.mappers;

import dima.springframework.msscbeerservice.domain.Beer;
import dima.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beer);

    BeerDto beerToBeerInventory(Beer beer);

    BeerDto beerToBeerDto(Beer beer);
}
