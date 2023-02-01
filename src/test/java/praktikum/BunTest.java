package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    //constructor (name)
    @Test
    public void constructorSetCorrectName() {
        //Arrange
        String expectedName = DataGenerator.randomName();

        //Act
        Bun bun = new Bun(expectedName, 100.0F);

        //Assert
        assertEquals("Конструктор устанавливает неверный name", expectedName, bun.name);

    }

    //constructor (price)
    @Test
    public void constructorSetCorrectPrice() {
        //Arrange
        float expectedPrice = DataGenerator.randomPrice();

        //Act
        Bun bun = new Bun("Test bun", expectedPrice);

        //Assert
        assertEquals("Конструктор устанавливает неверный price", expectedPrice, bun.price, 0.0);

    }


    //getName
    @Test
    public void getNameReturnsCorrectName() {
        //Arrange
        String expectedResult = DataGenerator.randomName();
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
        float expectedResult = DataGenerator.randomPrice();
        Bun bun = new Bun("Test bun", expectedResult);

        //Act
        float actualResult = bun.getPrice();

        //Arrange
        assertEquals("getPrice возвращает неверное значение", expectedResult, actualResult, 0.0);


    }
}
