package praktikum;

import net.datafaker.Faker;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    //Constructor
    @Test
    public void constructorSetCorrectName() {
        //Arrange
        Faker faker = new Faker();
        String expectedName = faker.text().text(3,8);

        //Act
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName,100.0F);
        String actualName = ingredient.name;

        //Assert
        assertEquals("Конструктор сохраняет неверное имя", expectedName, actualName);
    }

    @Test
    public void constructorSetCorrectPrice() {
        //Arrange
        Random random = new Random();
        float expectedPrice = random.nextFloat() * 100.0F;

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
        Faker faker = new Faker();
        String expectedName = faker.text().text(3,8);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName,100.0F);

        //Act
        String actualName = ingredient.getName();

        //Assert
        assertEquals("getName возвращает неверное имя", expectedName, actualName);

    }

    //getName
    @Test
    public void getNameReturnsCorrectPrice() {
        //Arrange
        Random random = new Random();
        float expectedPrice = random.nextFloat() * 100.0F;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test ingr", expectedPrice);

        //Act
        float actualPrice = ingredient.getPrice();

        //Assert
        assertEquals("getPrice возвращает неверную price", expectedPrice, actualPrice, 0);

    }


}
