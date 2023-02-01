package praktikum;

import net.datafaker.Faker;

import java.util.Random;

//генерация случайных данных
public class DataGenerator {

    //случайное имя
    public static String randomName() {
        Faker faker = new Faker();
        return faker.text().text(3, 8);
    }

    //случайная цена
    public static float randomPrice() {
        Random random = new Random();
        return random.nextFloat() * 100.0F;
    }
}
