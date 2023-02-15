package praktikum;


import org.junit.Test;


import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BurgerTest {

    //setBuns
   @Test
    public void setBunsSetCorrectBun() {
        //Arrange
        Bun bun = new Bun(DataGenerator.randomName(), DataGenerator.randomPrice());
        Burger burger = new Burger();

        //Act
        burger.setBuns(bun);

        //Assert
        assertThat("Burger.bun передан некорректно", burger.bun, equalTo(bun));

    }

    //addIngredient
    @Test
    public void addIngredientAddCorrectItem() {

       //Arrange
       Ingredient ingredient = new Ingredient(DataGenerator.randomType(), DataGenerator.randomName(),
               DataGenerator.randomPrice());
       Burger burger = new Burger();

       //Act
       burger.addIngredient(ingredient);

       //Assert
       assertTrue("Элемент не добавлен в ingredients", burger.ingredients.contains(ingredient));

    }

    //removeIngredient
    @Test
    public void removeIngredientRemoveCorrectItem() {

       //Arrange
        Ingredient ingredient = new Ingredient(DataGenerator.randomType(), DataGenerator.randomName(),
                DataGenerator.randomPrice());
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int indexForRemove = burger.ingredients.indexOf(ingredient);

       //Act
        burger.removeIngredient(indexForRemove);
       //Assert
        assertFalse("Элемент не удалён из ingredients", burger.ingredients.contains(ingredient));
    }

    //moveIngredient
    public void moveIngredientMoveItemToCorrectPlace() {

       //Arrange
        Random random = new Random();
        List<TestIngredient> ingredients = DataGenerator.randomIngredients();
        Burger burger = new Burger();
        for (TestIngredient item : ingredients) {
            burger.ingredients.add(new Ingredient(item.getType(), item.getName(), item.getPrice()));
        }
        int indexToMove = random.nextInt(burger.ingredients.size());


    }


    //getPrice
    //мокаем burger и ingredient
    //считаем - сравниваем

    //getReceipt


    @Test
    public void test() {
        System.out.println(DataGenerator.randomIngredients());
    }


}
