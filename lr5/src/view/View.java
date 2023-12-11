package view;

import java.util.Scanner;

public class View {
    public static Scanner in = new Scanner(System.in);
    public static String viewInput(){
        return in.nextLine();
    }
    public static void viewMessage(String message) {
        System.out.println(message);
    }
    public static void viewNumber(int number)
    {
        System.out.println(number);
    }
    public static String viewGetString(String message){
        System.out.println(message);
        return in.nextLine();
    }

}
