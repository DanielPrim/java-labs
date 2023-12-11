package model;

import controller.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Logging {
    public final static ArrayList<Exception> errList = new ArrayList<>();
    public void AddANote(String message)
    {
        try(FileWriter writer = new FileWriter("Log.txt", true)){

            writer.write(LocalDate.now().toString() + " " + LocalTime.now().toString() + " " + message + "\n");
        }catch (IOException exc)
        {
            errList.add(exc);
            Controller.controllerPrintMessage("Ошибка открытия файла");
        }
    }
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
