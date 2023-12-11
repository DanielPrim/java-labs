package controller;
import model.InitialSettings;
import model.Menu;
import model.ProductLog;
import model.enums.NameBulkCargos;
import model.enums.NameCars;
import model.enums.NameContainers;
import model.enums.NameLiquids;
import model.products.*;
import model.Train;
import view.View;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    /**
     * Main
     */
    public static void controllerMain() {
        try {
            InitialSettings initialSettings = new InitialSettings();
            Menu.menu();
        }catch (IOException e)
        {
            View.viewMessage(e.getMessage());
        }
    }

    /**
     * Выводит передаваемое сообщение, обращаясь к View
     * @param message - сообщение
     */
    public static void controllerPrintMessage(String message){
        View.viewMessage(message);
    }

    /**
     * Позволяет ввести число после выведенного сообщения
     * @param message - выводимое сообщение
     * @return вводимое число
     */
    public static int controllerGetInt(String message) {
        View.viewMessage(message);
        int number;
        while (true) {
            try {
                number = Integer.parseInt(View.viewInput());
            } catch (Exception e) {
                View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
                continue;
            }
            break;
        }
        return number;
    }

    /**
     * Позволяет ввести сообщение после выведенного сообщения
     * @param message - выводимое сообщение
     * @return - введенное сообщение
     */
    public static String controllerGetString(String message) {
        return View.viewGetString(message);
    }

    public static NameBulkCargos controllerGetNameBulkCargos(String message)
    {
        View.viewMessage(message);
        View.viewMessage("Зерно - 1, Уголь - 2, Песок - 3");
        while (true)
        {
            String arg = View.viewGetString("");
            switch (arg)
            {
                case("1"):
                    return NameBulkCargos.SEED;
                case("2"):
                    return NameBulkCargos.COAL;
                case("3"):
                    return NameBulkCargos.SAND;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }
    public static NameCars controllerGetNameCars(String message)
    {
        View.viewMessage(message);
        View.viewMessage("Toyota Mark II - 1, BMW X5 - 2");
        while (true)
        {
            String arg = View.viewGetString("");
            switch (arg)
            {
                case("1"):
                    return NameCars.TOYOTA;
                case("2"):
                    return NameCars.BMW;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }
    public static NameContainers controllerGetNameContainers(String message)
    {
        View.viewMessage(message);
        View.viewMessage("Стандартный - 1, Специальный - 2");
        while (true)
        {
            String arg = View.viewGetString("");
            switch (arg)
            {
                case("1"):
                    return NameContainers.STANDARD;
                case("2"):
                    return NameContainers.SPECIAL;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }
    public static NameLiquids controllerGetNameLiquids(String message)
    {
        View.viewMessage(message);
        View.viewMessage("Нефть - 1, Дизель - 2, Мазут - 3");
        while (true)
        {
            String arg = View.viewGetString("");
            switch (arg)
            {
                case("1"):
                    return NameLiquids.OIL;
                case("2"):
                    return NameLiquids.DIESEL;
                case("3"):
                    return NameLiquids.FUEL_OIL;
                default:
                    View.viewMessage("Ошибка ввода. Попробуйте ещё раз: ");
            }
        }
    }

    /**
     * Промежуточный метод для получения данных о создании ArrayList
     * @param n количество создаваемых объектов
     * @return лист с данными, записываемыми в лог
     */
    public static ArrayList<Long> controllerComponentList(int n){
        ProductLog productLog = new ProductLog();
        ArrayList<Long> data = productLog.arrayListLog(n);
        return data;
    }
    /**
     * Промежуточный метод для получения данных о создании HashMap
     * @param n количество создаваемых объектов
     * @return лист с данными, записываемыми в лог
     */
    public static ArrayList<Long> controllerComponentMap(int n){
        ProductLog productLog = new ProductLog();
        ArrayList<Long> data = productLog.hashMapLog(n);
        return data;
    }
}
