// Solucionado Dia : 31/10/2025 || Alterado Última vez : 31/10/2025
// Segue o link para o problema : https://www.codewars.com/kata/5264d2b162488dc400000001

public class StopSpinningMyWords {

    public static String spinner(String original){
        String[] words = original.split(" ");
        String result = "";
        for(String w : words){
            if(w.length() >= 5){
                w = new StringBuilder(w).reverse().toString();
            }
            result += w + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(spinner("Hey fellow warriors"));
        System.out.println(spinner("This is a test"));
        System.out.println(spinner("This is another test"));
    }
    
}
