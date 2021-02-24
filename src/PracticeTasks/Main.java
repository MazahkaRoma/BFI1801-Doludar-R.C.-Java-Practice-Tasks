package PracticeTasks;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args)
    {
        HashMap<String,Integer> citiesAndPeople=new HashMap<>();
        citiesAndPeople.put("Москва",942208);
        millionsRounding(citiesAndPeople);
        float[] b= {0,0,0};
    }

    public static HashMap<String,Integer> millionsRounding(HashMap<String,Integer> citiesAndPeople)
    {
        citiesAndPeople.forEach((key1, value) -> value=(int)Math.ceil((double)value/1000000)*1000000);
        return citiesAndPeople;
    }

    public static float[] otherSides(float oneSide) { return new float[]{2*oneSide, (float)(oneSide*Math.sqrt(3))}; }

    public static String rps()
    {

    }
}
