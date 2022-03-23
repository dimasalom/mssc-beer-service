package dima.springframework.msscbeerservice.web.controller;

import dima.springframework.msscbeerservice.serveces.BeerService;
import dima.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService service;

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody @Validated BeerDto beerDto) {

        return new ResponseEntity<>(service.saveBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBeer(@PathVariable("id") UUID id, @RequestBody @Validated BeerDto beerDto) {
        //todo implementation
        return new ResponseEntity<>(service.updateBeer(id, beerDto), HttpStatus.NO_CONTENT);
    }
}
