package praktikum;

import net.datafaker.Faker;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class BunTest {

    //constructor (name)
    @Test
    public void constructorSetCorrectName() {
        //Arrange
        Faker faker = new Faker();
        String expectedName = faker.text().text(3,8);

        //Act
        Bun bun = new Bun(expectedName, 100.0F);

        //Assert
        assertEquals("Конструктор устанавливает неверный name", expectedName, bun.name);

    }

    //constructor (price)
    @Test
    public void constructorSetCorrectPrice() {
        //Arrange
        Random random = new Random();
        float expectedPrice = random.nextFloat() * 100;

        //Act
        Bun bun = new Bun("Test bun", expectedPrice);

        //Assert
        assertEquals("Конструктор устанавливает неверный price", expectedPrice, bun.price, 0.0);

    }


    //getName
    @Test
    public void getNameReturnsCorrectName() {
        //Arrange
        Faker faker = new Faker();
        String expectedResult = faker.text().text(3,8);
        Bun bun = new Bun(expectedResult, 100.0F);

        //Act
        String actualResult = bun.getName();

        //Assert
        assertEquals("getName возвращает неверное значение", expectedResult, actualResult);
    }

    //getprice
    @Test
    public void getPriceReturnsCorrectPrice() {
        //Arrange
        Random random = new Random();
        float expectedResult = random.nextFloat() * 100;
        Bun bun = new Bun("Test bun", expectedResult);

        //Act
        float actualResult = bun.getPrice();

        //Arrange
        assertEquals("getPrice возвращает неверное значение", expectedResult, actualResult, 0.0);


    }
}
