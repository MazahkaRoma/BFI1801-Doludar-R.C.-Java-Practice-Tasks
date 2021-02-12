package PracticeTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        TasksFromBlockOne BlockOne=new TasksFromBlockOne();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество минут:");
        while(true)
        {
            if (sc.hasNextInt())
            {
                int minutes = sc.nextInt();
                System.out.println("После преобразования количество минут равно: " + BlockOne.convert(minutes));
                break;
            }
            else System.out.println("Извините, но это явно не число. Попробуйте снова!");
        }
    }
}
