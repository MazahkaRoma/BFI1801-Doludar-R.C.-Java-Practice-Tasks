package PracticeTasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args)
    {
        System.out.println(noYelling("sdhfjdhfj"));
        System.out.println(xPronounce("xfdg x sdg zxf"));
        System.out.println(memeSum(16,19));
    }

    public static String sevenBoom(ArrayList<Integer> array) { return array.contains(7) ? "Boom": "There is no 7 in array"; }

    public static boolean cons(ArrayList<Integer> array)
    {
        array.sort(Comparator.naturalOrder());
        return array.get(array.size())-array.get(0) == array.size()-1;
    }

    public static String unmix(String string)
    {
        String res = "";
        for(int i = 1; i < string.length(); i+=2)
        {
            res+=string.charAt(1)+string.charAt(i-1);
        }
        return res;
    }

    public static String noYelling(String in)
    {

        int last = in.length()-1;

        for(int i = in.length() - 1; i>=0; i--)
        {
            if( in.charAt(i) == '!' || in.charAt(i) == '?' ) last = i;
            else break;
        }

        return in.substring(0,last+1);
    }

    public static String xPronounce(String in)
    {
        StringBuilder stringBuilder = new StringBuilder(in);
        for (int i = 0; i < stringBuilder.length(); i++)
        {
            if(stringBuilder.charAt(i) == 'x' && i == 0)
            {
                stringBuilder.replace(i,i+1,"z");
            }
            else if (stringBuilder.charAt(i) == 'x' && i != 0)
            {
                stringBuilder.replace(i,i+1,"csk");
            }
        }

        return stringBuilder.toString();
    }

    public static int largestGap(ArrayList<Integer> arrayList)
    {
        arrayList.sort(Comparator.naturalOrder());

        int maxGap = 0;
        for(int i = 1; i <= arrayList.size(); i++)
        {
            if(arrayList.get(i)-arrayList.get(i-1)>=maxGap) maxGap = arrayList.get(i)-arrayList.get(i-1);
        }
        return maxGap;
    }

    public static int func(String input)
    {
        StringBuilder tmp = new StringBuilder(input).reverse();
        int[] a = Arrays.stream(tmp.toString().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(a);
        String sa = IntStream.of(a).boxed().map(String::valueOf).collect(Collectors.joining());

        int res = Integer.parseInt(input) - Integer.parseInt(sa);
        return res > 0 ? res : 0;
    }

    public static String commonLastVowel(String sentence)
    {
        HashMap<Character,Integer> alph = new HashMap<>();

        for(int i = 0; i < sentence.length(); i++)
        {
            alph.put(sentence.charAt(i),alph.get(sentence.charAt(i))+1);
        }

        int res = 0;
        Character resCh = 0;
        for (Map.Entry<Character, Integer> entry : alph.entrySet())
        {
            if(entry.getValue()>res)
            {
                res=entry.getValue();
                resCh=entry.getKey();
            }
        }
        return resCh.toString();
    }

    public static int memeSum(int a, int b)
    {
        String res = "";
        int tmp = 0;
        if(b > a)
        {
            tmp=a;
            a=b;
            b=tmp;
        }

        while(a!=0)
        {
            int ta = a % 10;
            int tb = b % 10;
            res = (ta + tb) + res;
            a= a/10;
            b= b/10;
        }

        return Integer.parseInt(res);
    }
    public static String unrepeated(String string)
    {
        for (int i = 0; i < string.length(); i++)
        {
            while (string.lastIndexOf(string.charAt(i)) != string.indexOf(string.charAt(i)))
            {
                int index = string.lastIndexOf(string.charAt(i));
                string = string.substring(0, index) + string.substring(index + 1);
            }
        }
        return string;
    }
}
