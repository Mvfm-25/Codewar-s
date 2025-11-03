// Solucionado Dia : XX/XX/XXXX || Alterado Última vez : XX/XX/XXXX
// Segue o link para o problema : https://www.codewars.com/kata/5ca24526b534ce0018a137b5/train/java

import java.util.*;

public class OldSchoolPhone {

    private static final Map<String, String> MAP = createMap();

    private static Map<String, String> createMap() {
        Map<String, String> m = new HashMap<>();
        // 1
        m.put("1", "."); m.put("11", ","); m.put("111", "?"); m.put("1111", "!");
        // 2
        m.put("2", "a"); m.put("22", "b"); m.put("222", "c");
        // 3
        m.put("3", "d"); m.put("33", "e"); m.put("333", "f");
        // 4
        m.put("4", "g"); m.put("44", "h"); m.put("444", "i");
        // 5
        m.put("5", "j"); m.put("55", "k"); m.put("555", "l");
        // 6
        m.put("6", "m"); m.put("66", "n"); m.put("666", "o");
        // 7
        m.put("7", "p"); m.put("77", "q"); m.put("777", "r"); m.put("7777", "s");
        // 8
        m.put("8", "t"); m.put("88", "u"); m.put("888", "v");
        // 9
        m.put("9", "w"); m.put("99", "x"); m.put("999", "y"); m.put("9999", "z");
        // *
        m.put("*", "'"); m.put("**", "-"); m.put("***", "+"); m.put("****", "=");
        // 0
        m.put("0", " ");
        return Collections.unmodifiableMap(m);
    }

    public static void sendMessage(String message){

        StringBuilder builder = new StringBuilder(); 
        StringBuilder finished = new StringBuilder();

        boolean upper = false; 
        char[] letters = message.toCharArray();

        for(char c : letters){

            // Ignore spaces.
            if(Character.isWhitespace(c)){
                flusher(builder, finished, upper);
                continue;
            }

            // Lower to upper, upper to lower.
            if(c == '#'){
                flusher(builder, finished, upper);
                upper = !upper;
                continue;
            }

            // Numbers as literal
            if(c == '-'){
                if(!builder.isEmpty()){
                    finished.append(builder.toString());
                    builder.setLength(0);
                }
                continue;
            }

            if(!builder.isEmpty() && c == builder.charAt(builder.length() -1 )){
                builder.append(c);
            } else {
                flusher(builder, finished, upper);
                builder.append(c);
            }
        }

        flusher(builder, finished, upper);
        System.out.println(finished.toString());
        
    }

    private static void flusher(StringBuilder builder, StringBuilder finished, boolean upper){
        String mapped = MAP.get(builder.toString());
        if(builder.length() == 0){ return; }

        finished.append(upper ? mapped.toUpperCase() : mapped );
        builder.setLength(0);
    }

    public static void main(String[] args) {
        // hey
        sendMessage("4433999");
        // one two three
        sendMessage("666 6633089666084477733 33");
        //1984
        sendMessage("1-9-8-4-");
        // Dude
        sendMessage("3883 33");
        // A-z
        sendMessage("#2**#9999");
    }
    
}
