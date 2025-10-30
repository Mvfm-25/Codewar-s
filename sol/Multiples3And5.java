// Solucionado dia 29/10/2025 || Alterado Última vez : 29/10/2025
// Segue o link para o problema : https://www.codewars.com/kata/514b92a657cdc65150000006/train/java

public class Multiples3And5 {
    public static int solution(int n){
        // Contador para soma.
        int whole = 0;

        for(int i = 0; i < n; i++){
            if(i % 5 == 0){
                whole += i;
            } else if(i % 3 == 0){
                whole += i;
            }
        }

        return whole;
    }

    public static void main(String[] args) {
        System.out.println("Solução para 'n' como 10... Esperamos 23.");
        System.out.println(solution(10));
    }
}
