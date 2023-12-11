package model.products;

import java.util.Random;

public class RandomProduct {
    public static String[] liquidNames = {"Нефть", "Дизельное топливо", "Мазут"};
    public static String[] bulkCargoNames = {"Зерно", "Уголь", "Песок"};
    public static String[] containerNames = {"Специальные контейнеры"};
    public static String[] carNames = {"ВАЗ-2107"};
    public static int randomNumber(int max){
        Random random = new Random();
        return random.nextInt(max);
    }

    public static String randomName(String[] names){
        int i = randomNumber(names.length);
        return names[i];
    }

    public static Product generate(){
        Product product = null;
        int maxTypeNumber = 4;
        int typeNumber = randomNumber( maxTypeNumber) + 1;
        switch (typeNumber) {
            case(1):
                Product liquid = new Liquid(typeNumber, randomName(liquidNames), (randomNumber( 10)+1)*1000);
                product = liquid;
                break;
            case(2):
                Product bulkCargo = new BulkCargo(typeNumber, randomName(bulkCargoNames), (randomNumber( 10)+1)*1000);
                product = bulkCargo;
                break;
            case(3):
                Product container = new Container(typeNumber, randomName(containerNames), (randomNumber( 10)+1));
                product = container;
                break;
            case(4):
                Product car = new Car(typeNumber, randomName(carNames), (randomNumber( 10)+1));
                product = car;
                break;
            default:
                break;
        }
        return product;
    }
}
