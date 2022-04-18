package az.tarlan.fruits.persistance.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "fruits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fruit {
    @Id
    @GeneratedValue
    @Column(name = "fruit_id")
    private UUID fruitId;
    @Column(name = "fruit_name")
    private String fruitName;
}
