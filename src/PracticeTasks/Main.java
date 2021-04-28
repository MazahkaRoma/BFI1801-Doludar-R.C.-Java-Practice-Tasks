package PracticeTasks;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(collect("intercontinentalisationalism", 6) );
        System.out.println(nicoCipher("Пдадвдыж", "tes"));
        int[] mas ={1,2,3,4,5,6,7,8,9};
        System.out.println(twoProduct(mas, 45) );
        System.out.println(isExact(6) );
        System.out.println(fractions("0.(6)"));
        System.out.println(pilish_string("33314444"));
        System.out.println(generateNonconsecutive(4));

    }

    public static String hiddenAnagram(String str, String anagramLettersStr) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        anagramLettersStr = anagramLettersStr.toLowerCase().replaceAll("[^a-z]", "");

        List<Character> anagramChars = anagramLettersStr.chars().mapToObj(it -> (char) it).collect(Collectors.toList());

        StringBuilder resultBuilder = new StringBuilder();
        boolean isResultFound = false;

        for (int i = 0; i < str.length() && !isResultFound; i++)
        {
            resultBuilder = new StringBuilder();
            List<Character> tempAnagramChars = new ArrayList<>(anagramChars);
            for (int j = i; j < str.length(); j++)
            {
                char symbol = str.charAt(j);
                if (tempAnagramChars.contains(symbol))
                {
                    resultBuilder.append(symbol);
                    tempAnagramChars.remove(Character.valueOf(symbol));
                    if (tempAnagramChars.isEmpty())
                    {
                        isResultFound = true;
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }

        return isResultFound ? resultBuilder.toString() : "noutfond";
    }

    public static List<String> collect(String str, int n)
    {
        List<String> res = new ArrayList<>();
        for(int i = 0; i<str.length(); i +=n)
        {
            String tmp = i+n<str.length() ? str.substring(i,i+n): "";
            if(tmp=="") continue;
            res.add(tmp);
        }
        Collections.sort(res);
        return res;
    }

    public static String nicoCipher(String message, String key)
    {
        if (message.equals("")) return "";
        int[] keyValue = new int[key.length()];
        char[] keyChar = key.toCharArray();
        int min, index;
        for(int i = 0; i < key.length(); i++)
        {
            min = 1000;
            index = -1;
            for (int j = 0; j < key.length(); j++)
            {
                if (keyChar[j] < min){
                    min = keyChar[j];
                    index = j;
                }
            }
            if (index != -1)
            {
                keyChar[index] = 1000;
                keyValue[index] = i;
            }
        }
        int count = 0, length = message.length();
        while (length > key.length()){
            count++;
            length -= key.length();
        }
        if (length > 0) count++;
        String[] words = new String[count];
        for (int i = 0; i < count; i++){
            words[i] = "";
        }
        for (int i = 0; i < words.length; i++){
            for (int j = i * key.length(); j < (i + 1) * key.length(); j++){
                if (j < message.length()){
                    words[i] += message.charAt(j);
                }else{
                    words[i] += " ";
                }
            }
        }
        for (int i = 0; i < words.length; i++){
            char[] word = (words[i]).toCharArray();
            char[] temp = new char[word.length];
            for (int j = 0; j < keyValue.length; j++){
                temp[keyValue[j]] = word[j];
            }
            StringBuilder temp2 = new StringBuilder();
            for (char ch : temp){
                temp2.append(ch);
            }
            words[i] = temp2.toString();
        }
        StringBuilder result = new StringBuilder();
        for (String word : words){
            result.append(word);
        }
        return result.toString();
    }

    static int[] twoProduct(int[] input, int multi)
    {
        int[] res = new int[2];
        for(int i = 0; i < input.length; i++)
        {
            for(int j = i; j < input.length; j++)
            {
                if(input[i]*input[j] == multi)
                {
                    res[0] = input[0];
                    res[1] = input[1];
                }
            }
        }

        return res;
    }
    public static int[] isExact(int num, int n){
        if (num == 0)
        {
            return new int[]{};
        }
        if (num == 1)
        {
            return new int[]{1, 1};
        }
        n++;
        if (num % n == 0)
        {
            try
            {
                return new int[]{num, isExact(num / n, n)[1] + 1};
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                return new int[]{};
            }
        }
        else {
            return new int[]{};
        }
    }

    public static int[] isExact(int num)
    {
        if (num == 0)
        {
            return new int[]{};
        }
        if (num == 1)
        {
            return new int[]{1, 1};
        }
        if (num % 2 == 0)
        {
            try
            {
                return new int[]{num, isExact(num / 2, 2)[1] + 1};
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                return new int[]{};
            }
        }
        else {
            return new int[]{};
        }
    }

    public static String fractions(String num){
        int k = -1, s = -1;
        String intPart = "";
        String period = "";
        for (int i = 0; i < num.length(); i++){
            if (num.charAt(i) == '.'){
                k = i;
            }
            if (num.charAt(i) == '('){
                s = i;
            }
        }
        num = num.replace('(', ' ');
        num = num.replace(')', ' ');
        num = num.replaceAll(" ", "");
        intPart = num.substring(0, k);
        StringBuilder helper = new StringBuilder();
        if(s - k == 1){
            period = num.substring(k + 1);
            for (int i = 0; i < period.length(); i++){
                helper.append("9");
            }
        }else{
            String fraction = num.substring(k + 1);
            String partFraction = num.substring(k + 1, s);
            for (int i = 0; i < fraction.length() - partFraction.length(); i++){
                helper.append("9");
            }
            for (int i = 0; i < partFraction.length(); i++){
                helper.append("0");
            }
            period = Integer.toString(Integer.parseInt(fraction.toString()) - Integer.parseInt(partFraction.toString()));
        }
        int p, h, i = 2;
        if (!(period.equals("") || helper.toString().equals(""))){
            p = Integer.parseInt(period);
            h = Integer.parseInt(helper.toString());
        }else{
            p = -1;
            h = -1;
        }
        while (i < p || i < h){
            if ((p % i == 0) && (h % i == 0)){
                p /= i;
                h /= i;
                i = 2;
            }else {
                i++;
            }
        }
        int iP;
        if (!(intPart.equals(""))){
            iP = Integer.parseInt(intPart);
        }else{
            iP = -1;
        }
        return ((iP * h) + p) + "/" + h;
    }

    public static String pilish_string(String str){
        if (str.equals("")){
            return str;
        }
        while (str.contains(" ")){
            str = str.replace(" ", "");
        }
        if (str.length() > 77){
            str = str.substring(0,77);
        }
        StringBuilder result = new StringBuilder();
        int[] arr = new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        String tempWord = "";
        int counter = 0;
        int tempNum = arr[counter];
        for (int i = 0; i < str.length(); i++){
            if (tempNum > 0){
                tempWord += str.charAt(i);
                tempNum--;
            }else{
                counter++;
                tempNum = arr[counter] - 1;
                result.append(tempWord).append(" ");
                tempWord = "" + str.charAt(i);
            }
        }
        if (tempNum > 0){
            while (tempNum > 0){
                tempWord += tempWord.charAt(tempWord.length() - 1);
                tempNum--;
            }
            result.append(tempWord).append(" ");
        }else if(!(tempWord.equals(""))){
            result.append(tempWord).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static String generateNonconsecutive(int n){
        if (n < 1) return "";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder tempWord = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                tempWord.append("1");
            }else{
                tempWord.append("0");
            }
        }
        list.add(tempWord.toString());
        String zero = "";
        for (int i = 0; i < n; i++){
            zero += "0";
        }
        while (!(tempWord.toString().equals(zero))){
            for(int i = tempWord.length() - 1; i >= 0; i--){
                if (tempWord.charAt(i) == '1'){
                    tempWord.replace(i, i + 1, "0");
                    if (i == tempWord.length() - 2){
                        tempWord.replace(i + 1, i + 2, "1");
                        list.add(tempWord.toString());
                        break;
                    }else{
                        if (tempWord.toString().equals(zero)){
                            list.add(tempWord.toString());
                            break;
                        }
                        list.add(tempWord.toString());
                        boolean check = false;
                        for(int j = tempWord.length() - 1; j >= 0; j--){
                            if (tempWord.charAt(j) == '1'){
                                check = true;
                                tempWord.replace(j, j + 1, "0");
                                for (int k = j + 1; k < tempWord.length(); k++){
                                    if (k % 2 == (j + 1) % 2){
                                        tempWord.replace(k, k + 1, "1");
                                    }else{
                                        tempWord.replace(k, k + 1, "0");
                                    }
                                }
                                list.add(tempWord.toString());
                                break;
                            }
                        }
                        if(check){
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--){
            result.append(list.get(i)).append(" ");
        }
        result.replace(result.length() - 1, result.length(), "");
        return result.toString();
    }

    public static String isValid(String str){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            String symbol = str.substring(i, i+1);
            map.computeIfPresent(symbol, (key, val) -> val + 1);
            map.putIfAbsent(symbol, 1);
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            arr[i] = entry.getValue();
            i++;
        }
        boolean replace = false;
        for (int j = 1; j < arr.length; j++){
            if (arr[j - 1] != arr[j]){
                if (replace){
                    return "NO";
                }
                if (arr[j - 1] > arr[j]){
                    arr[j - 1]--;
                    replace = true;
                }else{
                    arr[j]--;
                    replace = true;
                }
            }
        }
        for (int j = 1; j < arr.length; j++){
            if (arr[j - 1] != arr[j] && replace){
                return "NO";
            }
        }
        return "YES";
    }

    public static int[][] sumsUp(int[] arr){
        int p = 0;
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] + arr[j] == 8){
                    p++;
                }
            }
        }
        int[][] result = new int[p][2];
        p = 0;
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] + arr[j] == 8){
                    result[p++] = new int[]{Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                }
            }
        }
        return result;
    }

}


