package PracticeTasks;



public class Main {

    public static void main(String[] args) {
        System.out.println(nameShuffle("A a"));


    }
    public static int oppositeHouse(int rightHouse, int streetLong) { return streetLong*2-rightHouse+1; }

    public static String nameShuffle(String FIO) { return FIO.split(" ")[1]+" "+FIO.split("")[0]; }

    public static float discount(int price, int discount) { return price-(price*discount)/100; }

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



}
