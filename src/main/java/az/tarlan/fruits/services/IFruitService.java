package az.tarlan.fruits.services;

import az.tarlan.fruits.exceptions.FruitNotFound;
import az.tarlan.fruits.web.models.FruitDto;

import java.util.List;
import java.util.UUID;

public interface IFruitService {
    FruitDto getFruitById(UUID fruitId) throws FruitNotFound;
    FruitDto saveNewFruit(FruitDto fruitDto);
    List<FruitDto> getByFruitName(String fruitName);
}
