package az.tarlan.fruits.mappers;

import az.tarlan.fruits.persistance.entities.Fruit;
import az.tarlan.fruits.web.models.FruitDto;
import org.springframework.stereotype.Component;

@Component
public class FruitMapper {
    public FruitDto fruitToFruitDto(Fruit fruit) {
        if (fruit!=null) {
            return FruitDto.builder()
                    .fruitId(fruit.getFruitId())
                    .fruitName(fruit.getFruitName())
                    .build();
        } else {
            return null;
        }
    }

    public Fruit fruitDtoToFruit(FruitDto fruitDto) {
        if (fruitDto!=null) {
            return Fruit.builder()
                    .fruitName(fruitDto.getFruitName())
                    .build();
        } else {
            return null;
        }
    }
}
