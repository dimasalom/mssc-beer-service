package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.bootstrap.BootsTrapLoader;
import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;


    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxt cat")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(BootsTrapLoader.BEER_3_UPC)
                .price(new BigDecimal("13.99"))
                .build();
        beerDto.setId(null);

        String jsonBody = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());

        mockMvc.perform(post("/api/v1/beer/").
                        contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerId() throws Exception {

        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxt cat")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(BootsTrapLoader.BEER_1_UPC)
                .price(new BigDecimal("12.99"))
                .build();
        beerDto.setId(null);
        String jsonBody = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isNoContent());

    }

    BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(BootsTrapLoader.BEER_1_UPC)
                .build();
    }
}