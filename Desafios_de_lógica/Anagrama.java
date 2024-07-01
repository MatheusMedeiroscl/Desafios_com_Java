import java.lang.reflect.Array;
import java.text.Normalizer;

import java.util.*;

/**
 * Anagrama
 */
public class Anagrama {

    
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.print("Digite a primeira palavra:");
            String primeiraPalavra = teclado.nextLine();

            System.out.print("Digite a segunda palavra:");
            String segundaPalavra = teclado.nextLine();

            if (primeiraPalavra.length() == 0 || segundaPalavra.length() == 0) {
                System.out.println("Palavras não digidas");
                break;
            }else{
                char[] primeiroArray = transformaEmArray(primeiraPalavra);
                char[] segundoArray = transformaEmArray(segundaPalavra);

                Arrays.sort(primeiroArray);
                Arrays.sort(segundoArray);


                if (Arrays.equals(primeiroArray,segundoArray)) {
                    System.out.println("são anagramas");

                }else{
                    System.out.println("não são anagramas");

                }


            }

            break;
        }
        
    }

    private static char[] transformaEmArray(String palavra){
        String str = configuraPalavra(palavra);
        char[] array = str.toCharArray();

        return array;
    }
    


    private static String configuraPalavra(String string) {
        String str =  Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        return str.toLowerCase();

    }
    

    
}