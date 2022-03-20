package dima.springframework.msscbeerservice.web.controller;

import dima.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("id") UUID id) {
        //todo implementation
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto) {
        //todo implementation
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBeer(@PathVariable("id") UUID id, @RequestBody BeerDto beerDto) {
        //todo implementation
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
