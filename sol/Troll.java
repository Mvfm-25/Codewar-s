// Solucionado dia 29/10/2025 || Alterado Última vez : 29/10/2025
// Segue o link para o problema : https://www.codewars.com/kata/52fba66badcd10859f00097e/java

public class Troll {
    public static String disemvowel(String str) {
        // Adcionado expressão regular para ignorar Maiúsculas ou Minúsculas.
        return str.replaceAll("(?i)[aeiou]", "");
    }

    public static void main(String[] args) {
        System.out.println("String original : 'And you call yourself a communist? LOL!'");
        System.out.println(disemvowel("And you call yourself a communist? LOL!"));
    }
}