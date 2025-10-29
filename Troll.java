// Solucionado dia 29/10/2025
// Segue o link para o problema : https://www.codewars.com/kata/52fba66badcd10859f00097e/java

import java.util.*;
public class Troll {
    public static String disemvowel(String str) {
       ArrayList<String> vowels = new ArrayList<>();
       vowels.add("a"); vowels.add("A"); vowels.add("e"); vowels.add("E"); vowels.add("i"); vowels.add("I"); vowels.add("o"); vowels.add("O"); vowels.add("u"); vowels.add("U");
      
       for (char c : str.toCharArray()){
         if (vowels.contains(String.valueOf(c))){
           str = str.replace(String.valueOf(c), "");
         }
       }
       return str;
    }
}