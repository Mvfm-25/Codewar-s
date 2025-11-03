import java.util.*;

public class OldSchoolPhoneReverse {

    private static final Map<String, String> MAP = createMap();
    private static final Map<String, String> REVERSE_MAP = createReverseMap();

    private static Map<String, String> createMap() {
        Map<String, String> m = new HashMap<>();
        m.put("1", "."); m.put("11", ","); m.put("111", "?"); m.put("1111", "!");
        m.put("2", "a"); m.put("22", "b"); m.put("222", "c");
        m.put("3", "d"); m.put("33", "e"); m.put("333", "f");
        m.put("4", "g"); m.put("44", "h"); m.put("444", "i");
        m.put("5", "j"); m.put("55", "k"); m.put("555", "l");
        m.put("6", "m"); m.put("66", "n"); m.put("666", "o");
        m.put("7", "p"); m.put("77", "q"); m.put("777", "r"); m.put("7777", "s");
        m.put("8", "t"); m.put("88", "u"); m.put("888", "v");
        m.put("9", "w"); m.put("99", "x"); m.put("999", "y"); m.put("9999", "z");
        m.put("*", "'"); m.put("**", "-"); m.put("***", "+"); m.put("****", "=");
        m.put("0", " ");
        return Collections.unmodifiableMap(m);
    }

    private static Map<String, String> createReverseMap() {
        Map<String, String> rm = new HashMap<>();
        for (var e : MAP.entrySet()) {
            rm.put(e.getValue(), e.getKey());
        }
        return Collections.unmodifiableMap(rm);
    }

    public static String sendMessage(String message) {
        StringBuilder result = new StringBuilder();

        boolean upper = false;
        String previous = "";

        for (char raw : message.toCharArray()) {
            String c = String.valueOf(raw);

            // Space
            if (c.equals(" ")) {
                result.append("0");
                previous = "0";
                continue;
            }

            // Number literal: append n-
            if (Character.isDigit(raw)) {
                result.append(raw).append("-");
                previous = "-";
                continue;
            }

            // Toggle case if needed
            boolean shouldUpper = Character.isUpperCase(raw);
            char lower = Character.toLowerCase(raw);

            if (Character.isLetter(raw) && upper != shouldUpper) {
                result.append("#");
                upper = shouldUpper;
                previous = "";
            }

            String code = REVERSE_MAP.get(String.valueOf(lower));

            if (code == null) throw new IllegalArgumentException("Unsupported char: " + c);

            // If last digit equals first digit of current sequence → add space
            if (!previous.isEmpty() && previous.charAt(0) == code.charAt(0)) {
                result.append(" ");
            }

            result.append(code);
            previous = code;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sendMessage("hey"));
        System.out.println(sendMessage("one two three"));
        System.out.println(sendMessage("1984"));
        System.out.println(sendMessage("Dude"));
        System.out.println(sendMessage("A-z"));
    }
}
