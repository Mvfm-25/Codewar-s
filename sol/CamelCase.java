// Solucionado Dia : 03/11/2025 || Alterado Última vez : 03/11/2025
// Segue o link para o problema : https://www.codewars.com/kata/587731fda577b3d1b0001196

public class CamelCase {
    public static String camelCase(String original){
        if(original.isBlank()){return "";}

        String result = "";
        String[] pieces = original.split(" ");

        for(String p : pieces){
            if(p.isBlank()){ continue; }

            if(p.length() == 1){
                result += p.toUpperCase();
            } else {
                result += p.substring(0, 1).toUpperCase() + p.substring(1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String testSubject = "camel case method";

        System.out.println("String original : " + testSubject);
        System.out.println("Versão alterada : " + camelCase(testSubject));
    }
}
