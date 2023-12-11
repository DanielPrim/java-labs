package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.vans.*;
import model.products.*;


public class Train {
    static ArrayList<Van> list = new  ArrayList<Van>();
    static Map<Integer, Van> mapTrain = new HashMap <>();
    public void appendVan(Van van) {
        list.add(van);
    }

    public static ArrayList<Van> getList() {
        return list;
    }

    public void setList(ArrayList<Van> list) {
        this.list = list;
    }

    public static Map<Integer, Van> getMapTrain() {
        return mapTrain;
    }

    public void setMapTrain(Map<Integer, Van> mapTrain) {
        this.mapTrain = mapTrain;
    }

    public void appendMap(Integer i, Van van) {
        mapTrain.put(i, van);}

    public static Train loadingOfGoodsList(Warehouse warehouse) {
        Train train = new Train();
        for( Product p : warehouse.getProductList() ) {
            Product product = p;
            switch (product.getTypeNumber()) {
                case (1): // Для жидкостей
                    Liquid liquid = (Liquid) product;
                    int capacity1 = 1000;
                    int N1 = (int) Math.ceil(liquid.getQuantity() / capacity1);
                    for (int i1 = 0; i1<N1; i1++) {
                        LiquidTank liquidTank = new LiquidTank(liquid.getName(), capacity1);
                        train.appendVan(liquidTank);
                    }
                    break;

                case (2): // Для сыпучих грузов
                    BulkCargo bulkCargo = (BulkCargo) product;
                    int capacity2 = 1000;
                    int N2 = (int) Math.ceil(bulkCargo.getQuantity() / capacity2);
                    for (int i1 = 0; i1<N2; i1++) {
                        BulkCargoTank bulkCargoTank = new BulkCargoTank(bulkCargo.getName(), capacity2);
                        train.appendVan(bulkCargoTank);
                    }
                    break;

                case (3): // Для контейнеров
                    Container container = (Container) product;
                    int capacity3 = 2;
                    int N3 = (int) Math.ceil(container.getQuantity() / capacity3);
                    for (int i1 = 0; i1<N3; i1++) {
                        ContainerPlatform containerPlatform = new ContainerPlatform(container.getName(), capacity3);
                        train.appendVan(containerPlatform);
                    }
                    break;

                case (4): // Для автомобилей
                    Car car = (Car) product;
                    int capacity4 = 2;
                    int N4 = (int) Math.ceil(car.getQuantity() / capacity4);
                    for (int i1 = 0; i1<N4; i1++) {
                        CarPlatform carPlatform = new CarPlatform(car.getName(), capacity4);
                        train.appendVan(carPlatform);
                    }
                    break;

                default:
                    break;
            }
        }
        return train;
    }

    public static Train loadingOfGoodsMap(Warehouse warehouse) {
        Train train = new Train();
        int i = 0;
        for( Product p : warehouse.getProductList()) {
            switch (p.getTypeNumber()) {
                case (1) -> { // Для жидкостей
                    Liquid liquid = (Liquid) p;
                    int capacity1 = 1000;
                    int N1 = (int) Math.ceil(liquid.getQuantity() / capacity1);
                    for (int i1 = 0; i1 < N1; i1++) {
                        LiquidTank liquidTank = new LiquidTank(liquid.getName(), capacity1);
                        train.appendMap(i + i1, liquidTank);
                    }
                    i += N1;
                }
                case (2) -> { // Для сыпучих грузов
                    BulkCargo bulkCargo = (BulkCargo) p;
                    int capacity2 = 1000;
                    int N2 = (int) Math.ceil(bulkCargo.getQuantity() / capacity2);
                    for (int i1 = 0; i1 < N2; i1++) {
                        BulkCargoTank bulkCargoTank = new BulkCargoTank(bulkCargo.getName(), capacity2);
                        train.appendMap(i + i1, bulkCargoTank);
                    }
                    i += N2;
                }
                case (3) -> { // Для контейнеров
                    Container container = (Container) p;
                    int capacity3 = 2;
                    int N3 = (int) Math.ceil(container.getQuantity() / capacity3);
                    for (int i1 = 0; i1 < N3; i1++) {
                        ContainerPlatform containerPlatform = new ContainerPlatform(container.getName(), capacity3);
                        train.appendMap(i + i1, containerPlatform);
                    }
                    i += N3;
                }
                case (4) -> { // Для автомобилей
                    Car car = (Car) p;
                    int capacity4 = 2;
                    int N4 = (int) Math.ceil(car.getQuantity() / capacity4);
                    for (int i1 = 0; i1 < N4; i1++) {
                        CarPlatform carPlatform = new CarPlatform(car.getName(), capacity4);
                        train.appendMap(i + i1, carPlatform);
                    }
                    i += N4;
                }
                default -> {
                }
            }
            }
        return train;
    }

    public static Van generatorVan(Product product){
        while (true){
            switch (product.getTypeNumber()) {
                case (1): // Для жидкостей
                    Liquid liquid = (Liquid) product;
                    LiquidTank liquidTank = new LiquidTank(liquid.getName(), liquid.getQuantity());
                    return liquidTank;

                case (2): // Для сыпучих грузов
                    BulkCargo bulkCargo = (BulkCargo) product;
                    BulkCargoTank bulkCargoTank = new BulkCargoTank(bulkCargo.getName(), bulkCargo.getQuantity());
                    return bulkCargoTank;

                case (3): // Для контейнеров
                    Container container = (Container) product;
                    ContainerPlatform containerPlatform = new ContainerPlatform(container.getName(), container.getQuantity());
                    return containerPlatform;

                case (4): // Для автомобилей
                    Car car = (Car) product;
                    CarPlatform carPlatform = new CarPlatform(car.getName(), car.getQuantity());
                    return carPlatform;

                default:
                    break;
            }
        }
    }
}
