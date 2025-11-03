// Solucionado Dia : XX/XX/XXXX || Alterado Última vez : XX/XX/XXXX
// Segue o link para o problema : https://www.codewars.com/kata/5ca24526b534ce0018a137b5/train/java

import java.util.*;

public class OldSchoolPhone {

    public static void sendMessage(String message){
        Map<String, String> hash = new HashMap<>();
        // 1
        hash.put("1", "."); hash.put("11", ","); hash.put("111", "?"); hash.put("1111", "!");
        // 2
        hash.put("2", "a"); hash.put("22", "b"); hash.put("222", "c");
        // 3
        hash.put("3", "d"); hash.put("33", "e"); hash.put("333", "f");
        // 4 
        hash.put("4", "g"); hash.put("44", "h"); hash.put("444", "i");
        // 5
        hash.put("5", "j"); hash.put("55", "k"); hash.put("555", "l");
        // 6
        hash.put("6", "m"); hash.put("66", "n"); hash.put("666", "o");
        // 7
        hash.put("7", "p"); hash.put("77", "q"); hash.put("777", "r"); hash.put("7777", "s");
        // 8
        hash.put("8", "t"); hash.put("88", "u"); hash.put("888", "v");
        // 9
        hash.put("9", "w"); hash.put("99", "x"); hash.put("999", "y"); hash.put("9999", "z");
        // *
        hash.put("*", "'"); hash.put("**", "-"); hash.put("***", "+"); hash.put("****", "=");
        // 0
        hash.put("0", " ");


        StringBuilder builder = new StringBuilder(); 
        StringBuilder finished = new StringBuilder();

        boolean upper = false; 
        char[] letters = message.toCharArray();

        for(char c : letters){

            // Ignore spaces.
            if(Character.isWhitespace(c)){
                finished.append(hash.get(builder.toString()));
                builder.setLength(0);
                continue;
            }

            // Lower to upper, upper to lower.
            if(c == '#'){
                upper = !upper;
            }

            // Numbers as literal
            if(c == '-'){
                finished.append(builder.toString());
                builder.setLength(0);
                continue;
            }

            if(!builder.isEmpty() && c == builder.charAt(builder.length() -1 )){
                builder.append(c);
            } else {
                if(!builder.isEmpty()){
                    if(upper){
                        finished.append(hash.get(builder.toString()).toUpperCase());
                        builder.setLength(0);                        
                    } else {
                        finished.append(hash.get(builder.toString()));
                        builder.setLength(0);
                    }
                }

                builder.append(c);
            }
        }

        if(!builder.isEmpty()){
            finished.append(hash.get(builder.toString()));
            builder.setLength(0);
        }

        System.out.println(finished.toString());
        
    }

    public static void main(String[] args) {
        // hey
        sendMessage("4433999");
        // one two three
        sendMessage("666 6633089666084477733 33");
        //1984
        sendMessage("1-9-8-4-");
        // A-z
        sendMessage("#2**#9999");
    }
    
}
