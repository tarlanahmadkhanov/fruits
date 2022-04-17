package az.tarlan.fruits.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FruitDto {
    @Null
    private UUID fruitId;
    @NotNull
    @Size(min = 3, max = 35)
    private String fruitName;
}
