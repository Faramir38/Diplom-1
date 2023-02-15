package praktikum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//тестовый ингредиент (в отличие от основного - в этом я знаю что лежит)
@Getter
@AllArgsConstructor
@ToString
public class TestIngredient {
    private IngredientType type;
    private String name;
    private float price;
}
