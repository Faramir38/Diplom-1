package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType ingredientType;

    public IngredientParamTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    //Constructor (type)
    @Test
    public void constructorSetCorrectType() {
        //Arrange
        String name = DataGenerator.randomName();
        float price = DataGenerator.randomPrice();

        //Act
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actual = ingredient.type;

        //Assert
        assertThat("Конструктор сохраняет неверный тип ингредиента", actual, equalTo(ingredientType));
    }

    //getType
    @Test
    public void getTypeReturnsCorrectType() {
        //Arrange
        String name = DataGenerator.randomName();
        float price = DataGenerator.randomPrice();
        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        //Act
        IngredientType actual = ingredient.getType();

        //Assert
        assertThat("getType возвращает неверный тип ингредиента", actual, equalTo(ingredientType));
    }


}
