package PracticeTasks;


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String menu= "-----------------ЗАДАНИя ВТОРОГО БЛОКА-----------------\n"+
                        "1. oppositeHouse(int rightHouse, int streetLong)\n"+
                        "2. nameShuffle(String FIO)\n"+
                        "3. discount(int price, int discount)\n"+
                        "4. differenceMaxMin(double[] mas)\n"+
                        "5. equal(int a,int b,int c)\n"+
                        "6. reverse(String upcomingString)\n"+
                        "7. programmers(float first,float second,float third)\n"+
                        "8. getXO(String XO)\n"+
                        "9. bomb(String Sentence)\n"+
                        "10.sameAscii(String a,String b)\n"+
                        "0. Выход\n";
        System.out.println(menu);
        while(true)
        {
            int choice;
            try
            {
                choice = Integer.parseInt(getInput("Введите номер задания")[0]);
            }
            catch (Exception exp)
            {
                System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+"\nПовторите попытку");
                continue;
            }
            switch (choice)
            {
                case 1:
                    while(true)
                    {
                        try {
                            String[] houseAndStreet=getInput("Введите количество номер дома и длинну улицы: ");
                            System.out.println(oppositeHouse(Integer.parseInt(houseAndStreet[0]),
                                                             Integer.parseInt(houseAndStreet[1])
                                                            ));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 2:
                    while(true)
                    {
                        try {
                            String[] FIO=getInput("Введите имя и фамилию");
                            System.out.println(nameShuffle(FIO[0]));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 3:
                while(true)
                {
                    try {
                        String[] priceData=getInput("Введите данные для рассчета скидки(цена, скидка%)");
                        System.out.println(discount(Integer.parseInt(priceData[0]), Integer.parseInt(priceData[1])));
                        break;
                    }
                    catch (Exception exp){
                        System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                        continue;
                    }
                }
                break;
                case 4:
                    while(true)
                    {
                        try {
                            String[] sArray=getInput("Введите массив чисел: ");
                            double[] dArray= Arrays.stream(sArray).mapToDouble(Double::parseDouble).toArray();
                            System.out.println(differenceMaxMin(dArray));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 5:
                    while(true)
                    {
                        try {
                            String[] sArray=getInput("Введите три целых числа: ");
                            System.out.println(equal(Integer.parseInt(sArray[0]),
                                                     Integer.parseInt(sArray[1]),
                                                     Integer.parseInt(sArray[2])
                                                    ));;
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 6:
                    while(true)
                    {
                        try {
                            String[] sRev=getInput("Введите строку для реверса: ");
                            System.out.println(reverse(sRev[0]));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 7:
                    while(true)
                    {
                        try {
                            String[] sProgrammers=getInput("Введи почасовой заработок трех программистов: ");
                            System.out.println(programmers( Integer.parseInt(sProgrammers[0]),
                                                            Integer.parseInt(sProgrammers[1]),
                                                            Integer.parseInt(sProgrammers[2])
                                                            ));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 8:
                    while(true)
                    {
                        try {
                            String[] XO=getInput("Введите строку: ");
                            System.out.println(getXO(XO[0]));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 9:
                    while(true)
                    {
                        try {
                            String[] sentence=getInput("Введите предложение: ");
                            System.out.println(bomb(sentence.toString()));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 10:
                    while(true)
                    {
                        try {
                            String[] sentence=getInput("Введите строки для сравнения кодов ASCII: ");
                            System.out.println(sameAscii(sentence[0], sentence[1]));
                            break;
                        }
                        catch (Exception exp){
                            System.out.println("Ошибка ввода: "+ exp.getLocalizedMessage()+" Повторите попытку");
                            continue;
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод. Повторите попытку");
                    continue;
            }
        }

    }
    public static int oppositeHouse(int rightHouse, int streetLong) { return streetLong*2-rightHouse+1; }

    public static String nameShuffle(String FIO) { return FIO.split(" ")[1]+" "+FIO.split(" ")[0]; }

    public static float discount(int price, int discount)
    {
        return price-(price*discount)/100;
    }

    public static double differenceMaxMin(double[] mas)
    {
        double max=Double.MIN_VALUE;
        double min=Double.MAX_VALUE;
        for(int i = 0; i<mas.length; i++)
        {
            if(mas[i]>max) { max=mas[i]; }
            if(mas[i]<min) { min=mas[i]; }
        }
        return max-min;
    }

    public static int equal(int a,int b,int c)
    {
        int tmp=0;
        if (a==b) { tmp++; }
        if (a==c) { tmp++; }
        if (b==c) { tmp++; }
        return tmp;
    }

    public static String reverse(String upcomingString)
    {
        String sPalindrome= "";
        for(int i=upcomingString.length()-1;i>=0;i--)
        {
            sPalindrome+=upcomingString.charAt(i);
        }
        return sPalindrome;

    }

    public static float programmers(float first,float second,float third)
    {
        float max=first;
        float min=first;
        if (second < min) { min = second; }
        if (third < min) { min = third; }

        if (second > max) { max = second; }
        if (third > max) { max = third; }
        return max-min;
    }

    public static boolean getXO(String XO)
    {
        int countX=0;
        int countY=0;
        XO=XO.toLowerCase(Locale.ROOT);
        for (int i=0;i<XO.length();i++)
        {
            if (XO.charAt(i)=='x') { countX++; }
            if (XO.charAt(i)=='o') { countY++; }
        }
        return countX==countY;
    }

    public static String bomb(String Sentence)
    {
        if ( Sentence.contains("bomb") ) { return "DUCK!"; }
        return "Relax, there's no bomb.";
    }

    public static boolean sameAscii(String a,String b)
    {
        int sumA=0;
        int sumB=0;

        for (int i=0; i<a.length(); i++) { sumA += (int)a.charAt(i); }
        for (int i=0; i<b.length(); i++) { sumB += (int)b.charAt(i); }

        return sumB==sumA;
    }

    public static String[] getInput(String message)
    {
        String[] output=null;
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNextLine())
        {
            output=scanner.nextLine().split(" ");
        }
        return output;
    }


}
