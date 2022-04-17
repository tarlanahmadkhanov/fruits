package az.tarlan.fruits.web.controllers;

import az.tarlan.fruits.exceptions.FruitNotFound;
import az.tarlan.fruits.services.IFruitService;
import az.tarlan.fruits.utils.FruitUtils;
import az.tarlan.fruits.web.models.FruitDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/fruit")
@RestController
public class FruitController {
    private final IFruitService fruitService;

    private final FruitUtils fruitUtils;

    public FruitController(IFruitService fruitService, FruitUtils fruitUtils) {
        this.fruitService = fruitService;
        this.fruitUtils = fruitUtils;
    }

    @GetMapping("/{fruitId}")
    public ResponseEntity<FruitDto> getFruitById(@PathVariable("fruitId") UUID fruitId) {

        try {
          return new ResponseEntity(fruitService.getFruitById(fruitId), HttpStatus.OK);
        } catch (FruitNotFound fruitNotFound) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity saveNewFruit(@RequestBody @Validated FruitDto fruitDto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Created-fruit-id", fruitService.saveNewFruit(fruitDto).getFruitId().toString());
        return new ResponseEntity(responseHeaders, HttpStatus.CREATED);
    }
}
