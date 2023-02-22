package praktikum;

import net.datafaker.Faker;

import java.util.Locale;

//генерация случайных данных
public class DataGenerator {

    //случайное имя
    public static String randomName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.food().ingredient();

    }

    //случайная цена
    public static float randomPrice() {
        Faker faker = new Faker();
        return (float) faker.number().randomDouble(2, 0, 100);
    }

    //случанйый тип
    public static IngredientType randomType() {
        Faker faker = new Faker();
        return IngredientType.values()[faker.number().numberBetween(0, 2)];
    }
}
