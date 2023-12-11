import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class TransportVehicle {
    private String brand;
    private String model;
    private double maxCargoWeight;
    private int passengerCount;
    private int maxSpeed;

    public TransportVehicle(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.maxCargoWeight = maxCargoWeight;
        this.passengerCount = passengerCount;
        this.maxSpeed = maxSpeed;
    }

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

class Motorcycle extends TransportVehicle {
    public Motorcycle(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

class Car extends TransportVehicle {
    public Car(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

class Truck extends TransportVehicle {
    public Truck(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

class Bus extends TransportVehicle {
    public Bus(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
    }
}

class Trailer extends TransportVehicle {
    private TransportVehicle towingVehicle;

    public Trailer(String brand, String model, double maxCargoWeight, int passengerCount, int maxSpeed, TransportVehicle towingVehicle) {
        super(brand, model, maxCargoWeight, passengerCount, maxSpeed);
        this.towingVehicle = towingVehicle;
    }

    @Override
    public double getMaxCargoWeight() {
        return super.getMaxCargoWeight() + towingVehicle.getMaxCargoWeight();
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed() - 20;
    }
}

class Logger {
    private List<String> log;
    private int addCount;
    private int removeCount;
    private long addTotalTime;
    private long removeTotalTime;

    public Logger() {
        log = new ArrayList<>();
        addCount = 0;
        removeCount = 0;
        addTotalTime = 0;
        removeTotalTime = 0;
    }

    public void addLogEntry(String operation, int index, long time) {
        String date = getCurrentDateTime();
        log.add(date + " - " + operation + ", ID = " + index + ", " + time);

        if (operation.equals("add")) {
            addCount++;
            addTotalTime += time;
        } else if (operation.equals("remove")) {
            removeCount++;
            removeTotalTime += time;
        }
    }

    public void printLog() {
//        System.out.println("ArrayList");

        // Дополнение лога в файл
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            for (String entry : log) {
                writer.println(entry);
            }
            writer.println("addTotalCount = " + addCount);
            writer.println("addTotalTime = " + addTotalTime);
            writer.println("addMedianTime = " + (addTotalTime / addCount));
            writer.println("removeTotalCount = " + removeCount);
            writer.println("removeTotalTime = " + removeTotalTime);
            writer.println("removeMedianTime = " + (removeTotalTime / removeCount));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Вывод лога на экран
//        for (String entry : log) {
//            System.out.println(entry);
//        }
//        System.out.println("addTotalCount = " + addCount);
//        System.out.println("addTotalTime = " + addTotalTime);
//        System.out.println("addMedianTime = " + (addTotalTime / addCount));
//        System.out.println("removeTotalCount = " + removeCount);
//        System.out.println("removeTotalTime = " + removeTotalTime);
//        System.out.println("removeMedianTime = " + (removeTotalTime / removeCount));
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}

class Main {
    // ...

    public static void main(String[] args) {
        List<TransportVehicle> vehiclesArrayList = new ArrayList<>();
        List<TransportVehicle> vehiclesLinkedList = new LinkedList<>();

        // 10

        System.out.println("10 start");

        // Заполнение коллекций случайными значениями
        generateRandomVehicles(vehiclesArrayList, 10);
//        System.out.println("step 1");
        generateRandomVehicles(vehiclesLinkedList, 10);
//        System.out.println("step 2");

        // Логирование операций для ArrayList
        Logger arrayListLogger10 = new Logger();
        System.out.println(vehiclesArrayList.size());
        performOperations(vehiclesArrayList, arrayListLogger10, 10);
//        System.out.println("step 3");

        // Логирование операций для LinkedList
        Logger linkedListLogger10 = new Logger();
        performOperations(vehiclesLinkedList, linkedListLogger10, 10);
//        System.out.println("step 4");

        // Вывод логов
        arrayListLogger10.printLog();
        linkedListLogger10.printLog();

        System.out.println("10 end");

        // 100

        System.out.println("100 start");

        // Заполнение коллекций случайными значениями
        generateRandomVehicles(vehiclesArrayList, 100);
        generateRandomVehicles(vehiclesLinkedList, 100);

        // Логирование операций для ArrayList
        Logger arrayListLogger100 = new Logger();
        performOperations(vehiclesArrayList, arrayListLogger100, 100);

        // Логирование операций для LinkedList
        Logger linkedListLogger100 = new Logger();
        performOperations(vehiclesLinkedList, linkedListLogger100, 100);

        System.out.println("100 end");

        // Вывод логов
        arrayListLogger100.printLog();
        linkedListLogger100.printLog();

        // 1000

        System.out.println("1000 start");

        // Заполнение коллекций случайными значениями
        generateRandomVehicles(vehiclesArrayList, 1000);
        generateRandomVehicles(vehiclesLinkedList, 1000);

        // Логирование операций для ArrayList
        Logger arrayListLogger1000 = new Logger();
        performOperations(vehiclesArrayList, arrayListLogger1000, 1000);

        // Логирование операций для LinkedList
        Logger linkedListLogger1000 = new Logger();
        performOperations(vehiclesLinkedList, linkedListLogger1000, 1000);

        System.out.println("1000 end");

        // Вывод логов
        arrayListLogger1000.printLog();
        linkedListLogger1000.printLog();

        // 10000

//        System.out.println("10000 start");
//
//        // Заполнение коллекций случайными значениями
//        generateRandomVehicles(vehiclesArrayList, 10000);
//        generateRandomVehicles(vehiclesLinkedList, 10000);
//
//        // Логирование операций для ArrayList
//        Logger arrayListLogger10000 = new Logger();
//        performOperations(vehiclesArrayList, arrayListLogger10000, 10000);
//
//        // Логирование операций для LinkedList
//        Logger linkedListLogger10000 = new Logger();
//        performOperations(vehiclesLinkedList, linkedListLogger10000, 10000);
//
//        System.out.println("10000 end");

        // Вывод логов
//        arrayListLogger10000.printLog();
//        System.out.println();
//        linkedListLogger10000.printLog();

        // 100000

//        System.out.println("100000 start");
//
//        // Заполнение коллекций случайными значениями
//        generateRandomVehicles(vehiclesArrayList, 100000);
//        generateRandomVehicles(vehiclesLinkedList, 100000);
//
//        // Логирование операций для ArrayList
//        Logger arrayListLogger100000 = new Logger();
//        performOperations(vehiclesArrayList, arrayListLogger100000, 100000);
//
//        // Логирование операций для LinkedList
//        Logger linkedListLogger100000 = new Logger();
//        performOperations(vehiclesLinkedList, linkedListLogger100000, 100000);
//
//        // Вывод логов
////        arrayListLogger100000.printLog();
////        System.out.println();
////        linkedListLogger100000.printLog();
//
//        System.out.println("100000 end");
    }

    private static void generateRandomVehicles(List<TransportVehicle> vehicles, int count) {
        Random random = new Random();
        String[] brands = {"Brand1", "Brand2", "Brand3", "Brand4", "Brand5"};
        String[] models = {"Model1", "Model2", "Model3", "Model4", "Model5"};
        int[] maxSpeeds = {100, 120, 150, 180, 200};

        for (int i = 0; i < count; i++) {
            String brand = brands[random.nextInt(brands.length)];
            String model = models[random.nextInt(models.length)];
            double maxCargoWeight = random.nextDouble() * 1000;
            int passengerCount = random.nextInt(10);
            int maxSpeed = maxSpeeds[random.nextInt(maxSpeeds.length)];

            vehicles.add(new TransportVehicle(brand, model, maxCargoWeight, passengerCount, maxSpeed));
        }
    }

    private static void performOperations(List<TransportVehicle> vehicles, Logger logger, int size) {
        Random random = new Random();

        // Добавление элементов
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            vehicles.add(random.nextInt(vehicles.size()), vehicles.get(i));
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            logger.addLogEntry("add", i, executionTime);
            startTime = endTime;
        }

        // Удаление элементов
        startTime = System.nanoTime();
        for (int i = size - 1; i >= 0; i--) {
            if (random.nextDouble() < 0.1) {
                vehicles.remove(i);
            }
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            logger.addLogEntry("remove", i, executionTime);
            startTime = endTime;
        }
    }
}