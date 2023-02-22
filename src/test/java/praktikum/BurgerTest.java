package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    //getPrice
    //мокаем burger и ingredient
    //считаем - сравниваем
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;
    @Mock
    Ingredient ingredientMock2;

    //setBuns
    @Test
    public void setBunsSetCorrectBun() {
        //Arrange
        Burger burger = new Burger();

        //Act
        burger.setBuns(bunMock);

        //Assert
        burger.bun.getName();
        Mockito.verify(bunMock).getName();
    }

    //addIngredient
    @Test
    public void shouldAddIngredient() {
        //Arrange
        Burger burger = new Burger();

        //Act
        burger.addIngredient(ingredientMock);

        //Assert
        assertTrue("Элемент не добавлен в ingredients", burger.ingredients.contains(ingredientMock));
    }

    //removeIngredient
    @Test
    public void shouldRemoveIngredient() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        int indexForRemove = burger.ingredients.indexOf(ingredientMock);

        //Act
        burger.removeIngredient(indexForRemove);

        //Assert
        assertFalse("Элемент не удалён из ingredients", burger.ingredients.contains(ingredientMock));
    }

    //moveIngredient
    @Test
    public void shouldMoveIngredient() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        int indexMoveTo = 1;

        //Act
        burger.moveIngredient(burger.ingredients.indexOf(ingredientMock), indexMoveTo);

        //Assert
        assertThat("Элемент не перемёщен внутри ingredients", burger.ingredients.indexOf(ingredientMock),
                equalTo(indexMoveTo));
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        //Arrange
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.setBuns(bunMock);
        float bunPrice = DataGenerator.randomPrice();
        float ingredientPrice = DataGenerator.randomPrice();
        float expectedPrice = bunPrice * 2 + ingredientPrice;

        //Act
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientMock.getPrice()).thenReturn(ingredientPrice);
        float actualPrice = burger.getPrice();

        //Assert
        assertThat("Ожидаемая цена burger не равна полученной", actualPrice, equalTo(expectedPrice));
    }

    //getReceipt
    @Test
    public void getReceiptReturnsCorrectString() {
        //Arrange
        Burger burger = new Burger();
        Burger burgerSpy = spy(burger);
        burgerSpy.addIngredient(ingredientMock);
        burgerSpy.setBuns(bunMock);
        float burgerPrice = DataGenerator.randomPrice();
        String bunName = DataGenerator.randomName();
        IngredientType ingredientType = DataGenerator.randomType();
        String ingredientName = DataGenerator.randomName();

        //Формируем ожидаемую строку
        StringBuilder sb = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        sb.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName));
        sb.append(String.format("(==== %s ====)%n", bunName));
        sb.append(String.format("%nPrice: %f%n", burgerPrice));
        String expectedString = sb.toString();

        //Act
        Mockito.when(bunMock.getName()).thenReturn(bunName);
        Mockito.when(ingredientMock.getType()).thenReturn(ingredientType);
        Mockito.when(ingredientMock.getName()).thenReturn(ingredientName);
        Mockito.when(burgerSpy.getPrice()).thenReturn(burgerPrice);
        String actualString = burgerSpy.getReceipt();

        //Assert
        assertThat("Строка рецепта выводится неверно", actualString, equalTo(expectedString));
    }
}
