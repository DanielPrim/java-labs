// Класс Транспортное средство
class Transport {
    private String brand;
    private String model;
    private double maxCargoWeight;
    private int passengerCount;
    private int maxSpeed;

    // Конструктор класса
    public Transport(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.maxCargoWeight = maxCargoWeight;
        this.passengerCount = passengerCount;
        this.maxSpeed = maxSpeed;
    }

    // Методы для получения значений свойств
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

// Класс Мотоцикл, наследуется от Транспортного средства
class Motorcycle extends Transport {
    // Конструктор класса
    public Motorcycle(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

// Класс Автомобиль, наследуется от Транспортного средства
class Car extends Transport {
    // Конструктор класса
    public Car(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

// Класс Грузовик, наследуется от Транспортного средства
class Truck extends Transport {
    // Конструктор класса
    public Truck(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

// Класс Автобус, наследуется от Транспортного средства
class Bus extends Transport {
    // Конструктор класса
    public Bus(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

// Класс Прицеп, наследуется от Транспортного средства
class Trailer extends Transport {
    // Конструктор класса
    public Trailer(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание объектов и демонстрация работы методов классов
        Motorcycle motorcycle = new Motorcycle("Yamaha", "FZ6", 0, 1, 200);
        Car car = new Car("Toyota", "Camry", 0, 4, 180);
        Truck truck = new Truck("Mercedes-Benz", "Actros", 10000, 2, 120);
        Bus bus = new Bus("Volkswagen", "Transporter", 0, 9, 160);
        Trailer trailer = new Trailer("Semitrailers", "Full-Trailers", 10000, 0, 0);

        System.out.println("Марка мотоцикла: " + motorcycle.getBrand());
        System.out.println("Модель мотоцикла: " + motorcycle.getModel());
        System.out.println("Максимальная скорость мотоцикла: " + motorcycle.getMaxSpeed());

        System.out.println("\nМарка автомобиля: " + car.getBrand());
        System.out.println("Модель автомобиля: " + car.getModel());
        System.out.println("Количество пассажиров в автомобиле: " + car.getPassengerCount());

        System.out.println("\nМарка грузовика: " + truck.getBrand());
        System.out.println("Модель грузовика: " + truck.getModel());
        System.out.println("Максимальная масса перевозимого груза грузовика: " + truck.getMaxCargoWeight());
        System.out.println("\nМарка автобуса: " + bus.getBrand());
        System.out.println("Модель автобуса: " + bus.getModel());
        System.out.println("Максимальная скорость автобуса: " + bus.getMaxSpeed());

        System.out.println("\nМарка прицепа: " + trailer.getBrand());
        System.out.println("Модель прицепа: " + trailer.getModel());
        System.out.println("Количество пассажиров в прицепе: " + trailer.getPassengerCount());
    }
}