package PracticeTasks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args)
    {
        HashMap<String,Integer> citiesAndPeople=new HashMap<>();
        citiesAndPeople.put("Москва",875000);
        citiesAndPeople.put("Nice", 942208);
        citiesAndPeople.put("Abu Dhabi", 1482816);
        millionsRounding(citiesAndPeople);
        System.out.println(citiesAndPeople);
        float[] othersides=otherSides(1);
        System.out.println("["+othersides[0]+","+othersides[1]+"]");
        System.out.println(rps("ROCK","PAPER"));
        System.out.println(warOfNumbers(new int[]{1,2,3,4}));
        System.out.println(reverseCase("SgjKdkAfaAffaRTG"));
        System.out.println(inator("Shrink"));
        System.out.println(isBreakFit(1, 1, 1, 1, 1));
        System.out.println(totalDistance(70.0, 7.0, 0, false));
        System.out.println(mean(new double[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println(parityAnalysis("243"));


    }

    public static void millionsRounding(HashMap<String,Integer> citiesAndPeople)
    {
        for(Map.Entry<String,Integer> entry : citiesAndPeople.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            value=(int)Math.round((double)value/1000000)*1000000;
            citiesAndPeople.put(key,value);
        }

    }

    public static float[] otherSides(float oneSide) { return new float[]{2*oneSide, (float)(oneSide*Math.sqrt(3))}; }

    public static String rps(String P1, String P2)
    {
        String rock="ROCK";
        String paper= "PAPER";
        String scissors="SCISSORS";

        if( P1.equals(P2) ) return "Ничья";

        else if ( (P1.equals(rock) && P2.equals(scissors)) ||
                (P1.equals(paper) && P2.equals(rock)) ||
                (P1.equals(scissors) && P2.equals(paper))) return "Игрок 1 выйграл";

        else return "Игрок 2 выйграл";
    }

    public static int warOfNumbers(int[] array)
    {
        int maxEven = Integer.MIN_VALUE;
        int maxNotEven = Integer.MIN_VALUE;

        for(int i=0;i<array.length;++i)
        {
            if(array[i]%2 == 0 && array[i] > maxEven) maxEven = array[i];
            if(array[i]%2 != 0 && array[i] > maxNotEven) maxNotEven = array[i];
        }
        return maxEven-maxNotEven;
    }

    public static String reverseCase(String str)
    {
        String output="";
        char[] chr=str.toCharArray();
        for(int i = 0; i<chr.length; i++)
        {
            if(Character.isLowerCase(chr[i])) output += Character.toUpperCase(chr[i]);
            else output += Character.toLowerCase(chr[i]);
        }
        return output;
    }

    public static String inator(String str)
    {
        String alph = "aeiouyAEIOUY";
        if(alph.contains(Character.toString(str.charAt(str.length()-1)))) return str+="-inator";
        else return str+="inator";
    }

    public static boolean isBreakFit(int a, int b, int c, int w, int h)
    {
        return ((a <= w && b <= h) || (a <= w && c <= h) || (b <= w && a <= h) || (b <= w && c <= h)
                || (c <= w && a <= h) || (c <= w && b <= h));
    }

    public static double totalDistance(double liters, double baseConsumption, int passengers, boolean conditioner) {
        double consumptionWithPassengers = baseConsumption + baseConsumption * passengers * 0.05;
        double consumptionWithConditioner = consumptionWithPassengers + consumptionWithPassengers * 0.1;
        if (conditioner) {
            return consumptionWithConditioner;
        } else {
            return consumptionWithPassengers;
        }

    }

    public static  double mean(double[] arr)
    {
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum+=arr[i];
        }
        return  sum/arr.length;
    }

    public static boolean parityAnalysis(String str)
    {
        int sum=0;
        for(int i=0; i < str.length(); i++)
        {
               sum += Integer.parseInt(Character.toString(str.charAt(i)));
        }
        return sum%2==Integer.parseInt(str)%2;
    }
}
