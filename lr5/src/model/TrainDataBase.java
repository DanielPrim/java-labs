package model;

import controller.Controller;
import model.products.*;
import model.vans.Van;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TrainDataBase {
    public ArrayList<Van> trainList = new ArrayList<Van>();
    public Logging logging = new Logging();
    public void ReadDataBase()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Train.dat")))
        {
            trainList =(ArrayList<Van>)ois.readObject();
        }
        catch(Exception ex){
            Logging.errList.add(ex);
            Controller.controllerPrintMessage(ex.getMessage());
        }
    }
    public void SaveDataBase()
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Train.dat")))
        {
            oos.writeObject(trainList);
        }
        catch(Exception ex){
            Logging.errList.add(ex);
            Controller.controllerPrintMessage(ex.getMessage());
        }
    }
    public String ToString()
    {
        String strBase = "Train: ";
        for(int i = 0; i < trainList.size(); i++)
        {
            strBase += "\n" + "#" + i + "\t" + trainList.get(i).toString();
        }
        return strBase;
    }
    public void AddObj()
    {
        String arg = Controller.controllerGetString("Выберите, товар какого типа вы хотите погрузить в состав? (Жидкость - 1, Сыпучий груз - 2, Контейнер - 3, Автомобиль - 4)");
        switch (arg)
        {
            case("1"):
                trainList.add(Train.generatorVan(new Liquid(1, Controller.controllerGetNameLiquids("Название товара:").toString(), Controller.controllerGetInt("Объем: "))));
                logging.AddANote("Добавление вагона в состав");
                break;
            case("2"):
                trainList.add(Train.generatorVan(new BulkCargo(2, Controller.controllerGetNameBulkCargos("Название товара:").toString(), Controller.controllerGetInt("Масса: "))));
                logging.AddANote("Добавление вагона в состав");
                break;
            case("3"):
                trainList.add(Train.generatorVan(new Container(3, Controller.controllerGetNameContainers("Название товара:").toString(), Controller.controllerGetInt("Количество: "))));
                logging.AddANote("Добавление вагона в состав");
                break;
            case("4"):
                trainList.add(Train.generatorVan(new Car(4, Controller.controllerGetNameCars("Название товара:").toString(), Controller.controllerGetInt("Введите количество: "))));
                logging.AddANote("Добавление вагона в состав");
                break;
            default:
                Controller.controllerPrintMessage("Ошибка ввода");
        }

    }
    public void ChangeObj()
    {
        int ind = Controller.controllerGetInt("Введите номер вагона для замены: ");
        String arg = Controller.controllerGetString("Выберите, товар какого типа вы хотите погрузить в состав? (Жидкость - 1, Сыпучий груз - 2, Контейнер - 3, Автомобиль - 4)");
        switch (arg)
        {
            case("1"):
                trainList.set(ind, Train.generatorVan(new Liquid(1, Controller.controllerGetNameLiquids("Название товара:").toString(), Controller.controllerGetInt("Объем: "))));
                logging.AddANote("Вагон №" + ind + " замененен");
                break;
            case("2"):
                trainList.set(ind, Train.generatorVan(new BulkCargo(2, Controller.controllerGetNameBulkCargos("Название товара:").toString(), Controller.controllerGetInt("Масса: "))));
                logging.AddANote("Вагон №" + ind + " замененен");
                break;
            case("3"):
                trainList.set(ind, Train.generatorVan(new Container(3, Controller.controllerGetNameContainers("Название товара:").toString(), Controller.controllerGetInt("Количество: "))));
                logging.AddANote("Вагон №" + ind + " замененен");
                break;
            case("4"):
                trainList.set(ind, Train.generatorVan(new Car(4, Controller.controllerGetNameCars("Название товара:").toString(), Controller.controllerGetInt("Введите количество: "))));
                logging.AddANote("Вагон №" + ind + " замененен");
                break;
            default:
                Controller.controllerPrintMessage("Ошибка ввода");
        }
    }
    public void DeleteObj()
    {
        try {
            int ind = Controller.controllerGetInt("Введите номер вагона для удаления: ");
            trainList.remove(ind);
            logging.AddANote("Вагон №" + ind + " удален из состава");
        }
        catch (Exception ex) {
            Controller.controllerPrintMessage("Ошибка ввода");
        }
    }
}