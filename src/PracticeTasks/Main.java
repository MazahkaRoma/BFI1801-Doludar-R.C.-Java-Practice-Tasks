package PracticeTasks;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            String menu = "-------------------Задание первого блока----------------------\n" +
                            "1. convert(int minutes)\n" +
                            "2. points(int TwoPoints, int ThreePoints)\n" +
                            "3. footballpoints(int win, int draw, int lose)\n" +
                            "4. divisibleByFive(int number)\n" +
                            "5. and(boolean a,boolean b)\n" +
                            "6. howManyWalls(int n,int width, int height)\n" +
                            "7. squared(int b)\n" +
                            "8. profitableGamble(double prob, double prize, double pay)\n" +
                            "9. frames(int minutes, int frame)\n" +
                            "10. mod(int first, int second)\n" +
                            "0. Выход\n";
            System.out.println(menu);
            while(true)
            {
                int choice;
                try
                {
                    choice = Integer.parseInt(getInput("Выбирте задание из списка: ")[0]);
                }
                catch (Exception exp)
                {
                    System.out.println("Ошибка: "+exp+" Повторите ввод\n");
                    continue;
                }
                switch (choice)
                {
                    case 1:
                        while(true)
                        {
                            try {
                                int number = Integer.parseInt(getInput("Введите колличество минут: ")[0]);
                                System.out.println("Колличество секунд равно: " + convert(number));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: "+exp+" Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 2:
                        while(true)
                        {
                            try {
                                String[] points = getInput("Введите колличество двух очковых и трех очковых: ");
                                System.out.println("Общая сумма очков: " + points(Integer.parseInt(points[0]), Integer.parseInt(points[1])));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: "+exp+" Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 3:
                        while(true)
                        {
                            try
                            {
                                String[] res = getInput("Введите результаты комманды по футболу: ");
                                System.out.println("Общая сумма очков: " +
                                                    footballpoints(Integer.parseInt(res[0]),
                                                    Integer.parseInt(res[1]),
                                                    Integer.parseInt(res[3]))
                                                    );
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: "+exp+" Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 4:
                        while(true) {
                            try
                            {
                                int division = Integer.parseInt(getInput("Введите число для проверки делимости на 5: ")[0]);
                                System.out.println("Результат проверики делимости: " + divisibleByFive(division));
                                break;
                            }
                            catch (Exception exp) {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 5:
                        while (true)
                        {
                            try
                            {
                                String[] bools = getInput("Введите логические выражения: ");
                                System.out.println("Результат проверки: " + and(Boolean.parseBoolean(bools[0]), Boolean.parseBoolean(bools[1])));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 6:
                        while (true)
                        {
                            try
                            {
                                String[] data = getInput("Введите данные для покраски стен: ");
                                System.out.println("Результат рассчета: " + howManyWalls(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 7:
                        while (true)
                        {
                            try
                            {
                                int square = Integer.parseInt(getInput("Введите данные для рассчета квадрата числа: ")[0]);
                                System.out.println("квадрат числа: " + squared(square));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 8:
                        while (true)
                        {
                            try
                            {
                                String[] pribil = getInput("Введите данные для рассчета прибыли: ");
                                System.out.println("Ответ прибыльно ли: " + profitableGamble(Double.parseDouble(pribil[0]), Double.parseDouble(pribil[1]), Double.parseDouble(pribil[2])));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 9:
                        while (true)
                        {
                            try
                            {
                                String[] FPSdata = getInput("Введите данные для рассчета кадров: ");
                                System.out.println("Рассчет FPS: " + frames(Integer.parseInt(FPSdata[0]), Integer.parseInt(FPSdata[1])));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 10:
                        while (true)
                        {
                            try
                            {
                                String[] ModData = getInput("Введите данные для рассчета остатка при делении: ");
                                System.out.println("Рассчет остатка: " + mod(Integer.parseInt(ModData[0]), Integer.parseInt(ModData[1])));
                                break;
                            }
                            catch (Exception exp)
                            {
                                System.out.println("Ошибка: " + exp + " Повторите ввод\n");
                                continue;
                            }
                        }
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неверный ввод данных,повторите попытку");
                        continue;

                }
            }
    }



    public static int convert(int minutes) { return  minutes*60; }

    public static int points(int TwoPoints, int ThreePoints) { return TwoPoints*2+ThreePoints*3; }

    public static int footballpoints(int win, int draw, int lose) { return win*2+draw*1+lose*0; }

    public static boolean divisibleByFive(int number) { return number%5==0; }

    public static boolean and(boolean a,boolean b) { return a && b; }

    public static int howManyWalls(int n,int width, int height) { return width*height/n; }

    public static int squared(int b){ return b*b; }

    public static boolean profitableGamble(double prob, double prize, double pay) { return (prob*prize)-pay>0; }

    public static int frames(int minutes, int frame) { return minutes*frame*60; }

    public static int mod(int first, int second) { return first-second*(first/second); }

    public static String[] getInput(String message)
    {
        String[] outputData=null;
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNextLine())
        {
            outputData=scanner.nextLine().split(" ");
        }

        return outputData;
    }



}
