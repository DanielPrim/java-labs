package model;

import controller.Controller;
import model.products.Product;
import model.products.RandomProduct;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Создание логов
 */
public class ProductLog {
    private final static ArrayList<Exception> errList = new ArrayList<>();

    /**
     * Создание лога о создании Array List cо случайными объектами
     * @param n - количество создаваемых объектов
     * @return - данные о создании ArrayList
     */
    public ArrayList<Long> arrayListLog(int n){
        ArrayList<Product> productArrayList = new ArrayList<>();
        long totalTime = 0;
        long startOperation;
        long stopOperation;
        ArrayList<Long> res = new ArrayList<>(4);
        try(FileWriter writer = new FileWriter("ProductLog.txt", true)){
            writer.write("Start program: %s %s \n".formatted(LocalDate.now(), LocalTime.now()));
            writer.write("ArrayList\n");
            for(int i = 0; i < n; i++){

                Product product = RandomProduct.generate();
                startOperation = System.nanoTime();
                productArrayList.add(product);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("add, ID = %d, %d\n".formatted(i+1, stopOperation - startOperation));
            }
            writer.write("AddTotalCount = %d\n".formatted(n));
            writer.write("AddTotalTime = %d\n".formatted(totalTime));
            writer.write("AddMedianTime = %d\n".formatted(totalTime/n));
            res.add(totalTime);
            res.add(totalTime/n);
            totalTime = 0;
            for(int i = 0; i < n/10; i++){
                int id = (int)(Math.random() * (n-n/10));
                startOperation = System.nanoTime();
                productArrayList.remove(id);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("remove, ID = %d, %d\n".formatted(id+1, stopOperation - startOperation));
            }
            writer.write("RemoveTotalCount = %d\n".formatted(n/10));
            writer.write("RemoveTotalTime = %d\n".formatted(totalTime));
            writer.write("RemoveMedianTime = %d\n".formatted(10*totalTime/n));
            res.add(totalTime);
            res.add(10*totalTime/n);
            writer.write("Finish program: %s %s \n\n".formatted(LocalDate.now(), LocalTime.now()));
        }
        catch (IOException exc)
        {
            errList.add(exc);
            System.out.println("Ошибка открытия файла");
        }
        return res;
    }
    /**
     * Создание лога о создании HashMap cо случайными объектами
     * @param n - количество создаваемых объектов
     * @return - данные о создании HashMap
     */
    public ArrayList<Long> hashMapLog(int n){
        HashMap<Integer, Product> productHashMap = new HashMap<>();
        long totalTime = 0;
        long startOperation;
        long stopOperation;
        ArrayList<Long> res = new ArrayList<>(4);
        try(FileWriter writer = new FileWriter("ProductLog.txt", true)) {
            writer.write("Start program: %s %s \n".formatted(LocalDate.now(), LocalTime.now()));
            writer.write("HashMap\n");
            for (int i = 0; i < n; i++) {
                int param = (int) (Math.random() * 100);
                Product product = RandomProduct.generate();
                startOperation = System.nanoTime();
                productHashMap.put(i, product);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("add, ID = %d, %d\n".formatted(i + 1, stopOperation - startOperation));
            }
            writer.write("AddTotalCount = %d\n".formatted(n));
            writer.write("AddTotalTime = %d\n".formatted(totalTime));
            writer.write("AddMedianTime = %d\n".formatted(totalTime / n));
            res.add(totalTime);
            res.add(totalTime/n);
            totalTime = 0;
            for (int i = 0; i < n / 10; i++) {
                int id = (int) (Math.random() * (n-n/10));
                startOperation = System.nanoTime();
                productHashMap.remove(id);
                stopOperation = System.nanoTime();
                totalTime += stopOperation - startOperation;
                writer.write("remove, ID = %d, %d\n".formatted(id + 1, stopOperation - startOperation));
            }
            writer.write("RemoveTotalCount = %d\n".formatted(n / 10));
            writer.write("RemoveTotalTime = %d\n".formatted(totalTime));
            writer.write("RemoveMedianTime = %d\n".formatted(10*totalTime / n));
            res.add(totalTime);
            res.add(10*totalTime/n);
            writer.write("Finish program: %s %s \n\n".formatted(LocalDate.now(), LocalTime.now()));
        }
        catch (IOException exc)
        {
            errList.add(exc);
            Controller.controllerPrintMessage("Ошибка открытия файла");
        }
        return res;
    }

    /**
     * Создание лога ошибок
     */
    public void errLog(){
        try(FileWriter writer = new FileWriter("ErrLog.txt", true))
        {
            for(Exception exc: errList)
                writer.write(exc.getMessage());
        }
        catch (IOException exc)
        {
            errList.add(exc);
            Controller.controllerPrintMessage("Ошибка открытия файла");
        }
    }
}
