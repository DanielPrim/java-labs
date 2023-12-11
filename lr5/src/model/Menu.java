package model;

import controller.Controller;
import view.Frame;

import java.io.IOException;

/**
 * Меню
 */
public class Menu {
    /**
     * Создание меню
     */
    static public void menu() {
        Logging logging = new Logging();
        try {
            InitialSettings initialSettings = new InitialSettings();
            boolean flag0 = true;
            String login = "";
            TrainDataBase trainDataBase = new TrainDataBase();

            while (flag0) {
                login = Controller.controllerGetString("Введите имя пользователя: ");
                String password = Controller.controllerGetString("Введите пароль: ");
                if (!login.equals(initialSettings.userName) || !password.equals(initialSettings.password)) {
                    Controller.controllerPrintMessage("Неверное имя пользователя или пароль.");
                }else {
                    flag0 = false;
                }
            }
            logging.AddANote(login + " Начало работы программы");
            Controller.controllerPrintMessage("******* Добро пожаловать - " + login + " *******");

            flag0 = true;
            if (initialSettings.root) {
                while (flag0) {
                    String item = Controller.controllerGetString("Введите:" +
                            "\n1 - Чтение объектов из файла" +
                            "\n2 - Запись объектов в файл" +
                            "\n3 - Вывести данные в консоль" +
                            "\n4 - Добавить объект" +
                            "\n5 - Изменить объект" +
                            "\n6 - Удалить объект" +
                            "\n7 - Графики" +
                            "\n0 - Выход");
                    switch (item) {
                        case ("1"):
                            trainDataBase.ReadDataBase();
                            logging.AddANote("Чтение данных");
                            break;
                        case ("2"):
                            trainDataBase.SaveDataBase();
                            logging.AddANote("Запись данных");
                            break;
                        case ("3"):
                            Controller.controllerPrintMessage(trainDataBase.ToString());
                            break;
                        case ("4"):
                            trainDataBase.AddObj();
                            break;
                        case ("5"):
                            trainDataBase.ChangeObj();
                            break;
                        case ("6"):
                            trainDataBase.DeleteObj();
                            break;
                        case ("7"):
                            Frame frame = new Frame();
                            break;
                        case ("0"):
                            flag0 = false;
                            break;
                        default:
                            Controller.controllerPrintMessage("Ошибка ввода");
                    }
                }
            } else {
                while (flag0) {
                    String item = Controller.controllerGetString("Введите:" +
                            "\n1 - Чтение объектов из файла" +
                            "\n2 - Вывести данные в консоль" +
                            "\n0 - Выход");
                    switch (item) {
                        case ("1"):
                            trainDataBase.ReadDataBase();
                            logging.AddANote("Чтение данных");
                            break;
                        case ("2"):
                            Controller.controllerPrintMessage(trainDataBase.ToString());
                            break;
                        case ("0"):
                            flag0 = false;
                            break;
                        default:
                            Controller.controllerPrintMessage("Ошибка ввода");
                    }
                }
            }
        } catch (IOException e) {
            Controller.controllerPrintMessage(e.getMessage());
            Logging.errList.add(e);
        }
        logging.AddANote("Завершение работы программы\n");
        logging.errLog();
    }
}