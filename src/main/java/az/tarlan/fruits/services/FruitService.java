package az.tarlan.fruits.services;

import az.tarlan.fruits.exceptions.FruitNotFound;
import az.tarlan.fruits.mappers.FruitMapper;
import az.tarlan.fruits.persistance.entities.Fruit;
import az.tarlan.fruits.persistance.repositories.FruitRepository;
import az.tarlan.fruits.web.models.FruitDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FruitService implements IFruitService {

    private final FruitRepository fruitRepository;

    private final FruitMapper fruitMapper;

    public FruitService(FruitRepository fruitRepository, FruitMapper fruitMapper) {
        this.fruitRepository = fruitRepository;
        this.fruitMapper = fruitMapper;
    }

    public FruitDto getFruitById(UUID fruitId) throws FruitNotFound {
        return fruitMapper.fruitToFruitDto(fruitRepository.findById(fruitId).orElseThrow(FruitNotFound::new));
    }

    public FruitDto saveNewFruit(FruitDto fruitDto) {
        return fruitMapper.fruitToFruitDto(fruitRepository.save(fruitMapper.fruitDtoToFruit(fruitDto)));
    }

    @Override
    public List<FruitDto> getByFruitName(String fruitName) {
        List<FruitDto> fruitDtos = new ArrayList<>();
        for (Fruit fruit: fruitRepository.findByFruitNameIgnoreCase(fruitName.toLowerCase())) {
            fruitDtos.add(fruitMapper.fruitToFruitDto(fruit));
        }
        return fruitDtos;
    }
}
