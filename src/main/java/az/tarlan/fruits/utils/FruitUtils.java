package az.tarlan.fruits.utils;

import az.tarlan.fruits.persistance.entities.Fruit;
import az.tarlan.fruits.web.models.FruitDto;
import org.springframework.stereotype.Component;

@Component
public class FruitUtils {
    public Fruit getValidFruit() {
        return Fruit.builder().fruitName("apple").build();
    }
    public FruitDto getValidFruitDto() {
        return FruitDto.builder().fruitName("apple").build();
    }
}
