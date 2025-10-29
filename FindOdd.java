// Solucionado Dia : 29/10/2025 || Alterado Última vez : 29/10/2025
// Segue o link para o problema : https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java

import java.util.*;
import java.util.stream.Collectors;

public class FindOdd {
    public static int oddInt(int[] ints){
        int found = 0;

        // XOR
        for(int n : ints){
            found ^= n;
        }

        return found;
    }

    public static void main(String[] args) {
        int[] teste1 ={3,3,3,4,4};
        int[] teste2 ={0,1,1,1,1};
        System.out.println(oddInt(teste1));
        System.out.println(oddInt(teste2));
    }
}
