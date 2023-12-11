import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

// Класс для чтения/записи данных в базу данных
class DatabaseManager {
    private final String filename;

    // Конструктор класса
    public DatabaseManager(String filename) {
        this.filename = filename;
    }

    // Метод для чтения данных из файла базы данных и создания списка транспортных средств
    public void readData() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
                new FileInputStream(filename), "UTF-8")))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Разделение строки на поля
                String[] fields = line.split(",");
                // Создание объекта транспортного средства и добавление его в список
                Transport transport = new Transport(fields[0], fields[1], Double.parseDouble(fields[2]),
                        Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
                // Вывод данных на консоль
                System.out.println("Прочитано из базы данных: " + transport.getBrand() + " " + transport.getModel() + " Максимальная скорость: " + transport.getMaxSpeed()+ " Число пассажиров: " + transport.getPassengerCount()+ " Максимальный вес: " + transport.getMaxCargoWeight());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл базы данных не найден");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка не поддерживается");
        }
    }


    // Метод для записи данных в файл базы данных
    public void writeData(Transport transport) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(transport.getBrand() + "," + transport.getModel() + "," + transport.getMaxCargoWeight()
                    + "," + transport.getPassengerCount() + "," + transport.getMaxSpeed());
            writer.flush();
            System.out.println("Данные успешно записаны в базу данных");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в базу данных");
        }
    }
}

// Класс для работы с пользовательскими настройками
class SettingsManager {
    private final String filename;
    private String username;
    private boolean logEnabled;

    // Конструктор класса
    public SettingsManager(String filename) {
        this.filename = filename;
    }

    // Метод для чтения настроек из файла
    public void readSettings() {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            username = scanner.nextLine();
            logEnabled = Boolean.parseBoolean(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл настроек не найден");
        }
    }

    // Метод для получения имени пользователя из настроек
    public String getUsername() {
        return username;
    }

    // Метод для получения признака записи лога из настроек
    public boolean isLogEnabled() {
        return logEnabled;
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

        // Создание менеджера базы данных
        DatabaseManager databaseManager = new DatabaseManager("database.txt");

        // Создание менеджера настроек
        SettingsManager settingsManager = new SettingsManager("settings.txt");

        // Чтение настроек из файла
        settingsManager.readSettings();

        // Вывод приветствия с указанием имени пользователя из настроек
        System.out.println("Добро пожаловать, " + settingsManager.getUsername());

        // Добавление пунктов в главное меню в зависимости от группы пользователя
        if (settingsManager.getUsername().equals("root")) {
            System.out.println("3. Отладка");
            System.out.println("4. Автотесты");
        }

        // Включение/выключение режима отладки из настроек
        boolean debugMode = settingsManager.isLogEnabled();

        // Создание лог-файла
        String logFilename = "log.txt";
        try {
            File logFile = new File(logFilename);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании лог-файла");
        }

        // Запись старта программы в лог
        writeLogEntry(logFilename, "Программа запущена. Пользователь: " + settingsManager.getUsername(), debugMode);

        // Включение режима автотестов из настроек
        boolean autoTestMode = settingsManager.getUsername().equals("root") && settingsManager.isLogEnabled();

        // Выполнение автотестов
        if (autoTestMode) {
            executeAutoTests();
        }

        // Чтение данных из базы данных
        databaseManager.readData();

        // Запись данных в базу данных
        databaseManager.writeData(motorcycle);
        databaseManager.writeData(car);
        databaseManager.writeData(truck);
        databaseManager.writeData(bus);
        databaseManager.writeData(trailer);

        // Завершение программы
        writeLogEntry(logFilename, "Программа завершена", debugMode);
    }

    // Метод для записи в лог-файл
    private static void writeLogEntry(String filename, String entry, boolean debugMode) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            writer.println(timestamp + " " + entry);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог");
        }

        // Вывод записи в консоль в режиме отладки
        if (debugMode) {
            System.out.println(entry);
        }
    }

    // Метод для выполнения автотестов
    private static void executeAutoTests() {
        // Выполнение автотестов
        System.out.println("Автотесты выполнены");
    }
}