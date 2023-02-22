package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {

    private final IngredientType itemType;
    private final String itemName;

    public IngredientTypeParamTest(IngredientType itemType, String itemName) {
        this.itemType = itemType;
        this.itemName = itemName;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void ingredientTypeItemHasCorrectName() {
        assertThat("valueOf возвращает неверный тип", IngredientType.valueOf(itemName), equalTo(itemType));
    }

}
