package dima.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dima.springframework.msscbeerservice.bootstrap.BeerLoader;
import dima.springframework.msscbeerservice.serveces.BeerService;
import dima.springframework.msscbeerservice.web.model.BeerDto;
import dima.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static dima.springframework.msscbeerservice.bootstrap.BeerLoader.*;
import static java.util.UUID.randomUUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    BeerService service;

    final String URL_TEMPLATE = "/api/v1/beer/";


    @Test
    void getBeerById() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Some beer")
                .price(new BigDecimal("4.66"))
                .beerStyle(BeerStyleEnum.IPA)
                .upc(BEER_UPC_1)
                .build();

        given(service.getById(any())).willReturn(beerDto);

        mockMvc.perform(get(URL_TEMPLATE + randomUUID())
                .accept(APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    void saveBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Some beer")
                .price(new BigDecimal("4.66"))
                .beerStyle(BeerStyleEnum.IPA)
                .upc(BEER_UPC_1)
                .build();

        String beerDtoJonObj = mapper.writeValueAsString(beerDto);

        mockMvc.perform(post(URL_TEMPLATE)
                .contentType(APPLICATION_JSON)
                .content(beerDtoJonObj))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Some beer")
                .price(new BigDecimal("4.66"))
                .beerStyle(BeerStyleEnum.IPA)
                .upc(BEER_UPC_1)
                .build();

        String beerDtoJonObj = mapper.writeValueAsString(beerDto);

        mockMvc.perform(put(URL_TEMPLATE + randomUUID())
                .contentType(APPLICATION_JSON)
                .content(beerDtoJonObj))
                .andExpect(status().isNoContent());
    }
}