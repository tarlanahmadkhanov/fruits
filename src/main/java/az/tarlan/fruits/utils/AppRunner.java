package az.tarlan.fruits.utils;

import az.tarlan.fruits.services.FruitService;
import az.tarlan.fruits.services.IFruitService;
import az.tarlan.fruits.web.models.FruitDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    private final IFruitService fruitService;

    public AppRunner(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void run(String... args)  {

        FruitDto apple = FruitDto.builder().fruitName("apple").build();
        FruitDto apple2 = FruitDto.builder().fruitName("Apple").build();
        FruitDto apple3 = FruitDto.builder().fruitName("APPLE").build();
        FruitDto apple4 = FruitDto.builder().fruitName("apple").build();
        FruitDto pear = FruitDto.builder().fruitName("pear").build();
        FruitDto orange = FruitDto.builder().fruitName("orange").build();
        FruitDto banana = FruitDto.builder().fruitName("banana").build();
        FruitDto mandarin = FruitDto.builder().fruitName("mandarin").build();

        fruitService.saveNewFruit(apple);
        fruitService.saveNewFruit(pear);
        fruitService.saveNewFruit(orange);
        fruitService.saveNewFruit(banana);
        fruitService.saveNewFruit(mandarin);
        fruitService.saveNewFruit(apple2);
        fruitService.saveNewFruit(apple3);
        fruitService.saveNewFruit(apple4);

    }
}
