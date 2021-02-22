package PracticeTasks;


import java.util.Locale;

public class Main {

    public static void main(String[] args)
    {



    }
    public static int oppositeHouse(int rightHouse, int streetLong) { return streetLong*2-rightHouse+1; }

    public static String nameShuffle(String FIO) { return FIO.split(" ")[1]+" "+FIO.split(" ")[0]; }

    public static float discount(int price, int discount)
    {
        return price-(price*discount)/100;
    }

    public static float differenceMaxMin(float[] mas)
    {
        float max=Float.MIN_VALUE;
        float min=Float.MAX_VALUE;
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
}
