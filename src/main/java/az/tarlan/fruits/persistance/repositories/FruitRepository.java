package az.tarlan.fruits.persistance.repositories;

import az.tarlan.fruits.persistance.entities.Fruit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FruitRepository extends CrudRepository<Fruit, UUID> {
    List<Fruit> findByFruitNameIgnoreCase(String name);
}
