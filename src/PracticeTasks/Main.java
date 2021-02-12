package PracticeTasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Map<String,TaskNumber> TaskMap= new HashMap<String,TaskNumber>();
        TaskMap.put("First",TaskNumber.First);
        TaskMap.put("Second",TaskNumber.Second);
        TaskMap.put("Third",TaskNumber.Third);
        TaskMap.put("Fourth",TaskNumber.Fourth);
        TaskMap.put("Fifth",TaskNumber.Fifth);
        TaskMap.put("Sixth",TaskNumber.Sixth);
        TaskMap.put("Seventh",TaskNumber.Seventh);
        TaskMap.put("Eighth",TaskNumber.Eighth);
        TaskMap.put("Ninth",TaskNumber.Ninth);
        TaskMap.put("Tenth",TaskNumber.Tenth);

        while(true)
        {
            System.out.print("""

                    Задания:
                    First: Перевод минут в секунды.
                    Second: Подсчет очков. Баскетбол.

                    """);
            System.out.println("Введите задание для выполнение: ");
            if(sc.hasNext())
            {
                String Task = sc.nextLine();
                switch (TaskMap.get(Task))
                {
                    case First:
                        while(true)
                        {
                            TasksFromBlockOne BlockOne = new TasksFromBlockOne();
                            System.out.print("Введите количество минут: ");
                            if (sc.hasNextInt())
                            {
                                System.out.println("Количество секунд равно: " + BlockOne.convert(sc.nextInt()));
                                break;
                            } else System.out.println("Некорректный ввод данных. Попробуйте еще раз ");
                        }
                        break;

                    case Second:
                        while(true)
                        {
                            TasksFromBlockOne BlockOne = new TasksFromBlockOne();
                            System.out.print("Введите количество двухочковых и трехочковых через пробел: ");
                            if (sc.hasNextInt())
                            {
                                System.out.println("Количество очков: " + BlockOne.points(sc.nextInt(), sc.nextInt()));
                                break;
                            } else System.out.println("Некорректный ввод данных. Попробуйте еще раз ");
                        }
                        break;


                }
            }
        }
    }
}
