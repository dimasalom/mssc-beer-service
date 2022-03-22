package dima.springframework.msscbeerservice.web.mappers;

import dima.springframework.msscbeerservice.domain.Beer;
import dima.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerDtoToBeer(Beer beer);

    Beer BeerToBeerDto(BeerDto beer);
}
