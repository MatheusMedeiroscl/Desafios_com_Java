
public class Sudoku {
    private static final int tamanho = 9;

   public static void main(String[] args) {
    int[][] sudoku = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    if(resolveSudoku(sudoku)){
        mostrar(sudoku);
    }else{
        System.out.println("Não pode ser resolvido");
    }
   }

    private static boolean resolveSudoku(int[][] sudoku) {
        for(int linha = 0; linha < tamanho; linha++){
            for(int coluna = 0; coluna < tamanho; coluna++){
                // Antes de buscar a resposta deve se perguntar se já tem ou não um numero na casa
                if (sudoku[linha][coluna] == 0) {
                    // Delimitar o numero que pode ser colocado
                    for(int num = 1; num <= tamanho; num++){ // Correção aqui
                        if(numeroValido(linha, coluna, num, sudoku)){
                            sudoku[linha][coluna] = num;

                            if(resolveSudoku(sudoku)){
                                return true;
                            }else{
                                sudoku[linha][coluna] = 0;
                            }
                        }
                    } 
                    return false;   
                }
            }
        }
        return true;
    }

    private static boolean numeroValido(int linha, int coluna, int num, int[][] sudoku) {
        // Valida a linha
        for(int x = 0; x < tamanho; x++){
            if (sudoku[linha][x] == num) {
                return false;
            }
        }
        // Valida a coluna
        for(int x = 0; x < tamanho; x++){
            if (sudoku[x][coluna] == num) { // Correção aqui
                return false;
            }
        }

        int startRow = linha - linha % 3;
        int startCol = coluna - coluna % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void mostrar(int[][] sudoku) {
        for(int l = 0; l < tamanho; l++){
            for(int c = 0; c < tamanho; c++){
                System.out.print(sudoku[l][c]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((l + 1) % 3 == 0 && l != tamanho - 1) {
                System.out.print("\n"); // Adiciona uma linha em branco entre as subgrades
            }

       
        }
    }
}
