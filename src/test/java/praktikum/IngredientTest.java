package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    //Constructor
    @Test
    public void constructorSetCorrectName() {
        //Arrange
        String expectedName = DataGenerator.randomName();

        //Act
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 100.0F);
        String actualName = ingredient.name;

        //Assert
        assertEquals("Конструктор сохраняет неверное имя", expectedName, actualName);
    }

    @Test
    public void constructorSetCorrectPrice() {
        //Arrange
        float expectedPrice = DataGenerator.randomPrice();

        //Act
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test ingr", expectedPrice);
        float actualPrice = ingredient.price;

        //Assert
        assertEquals("Конструктор сохраняет неверную price", expectedPrice, actualPrice, 0);
    }

    //getPrice
    @Test
    public void getNameReturnsCorrectName() {
        //Arrange
        String expectedName = DataGenerator.randomName();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 100.0F);

        //Act
        String actualName = ingredient.getName();

        //Assert
        assertEquals("getName возвращает неверное имя", expectedName, actualName);
    }

    //getName
    @Test
    public void getNameReturnsCorrectPrice() {
        //Arrange
        float expectedPrice = DataGenerator.randomPrice();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test ingr", expectedPrice);

        //Act
        float actualPrice = ingredient.getPrice();

        //Assert
        assertEquals("getPrice возвращает неверную price", expectedPrice, actualPrice, 0);
    }
}
