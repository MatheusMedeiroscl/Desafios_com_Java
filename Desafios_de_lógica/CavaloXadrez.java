

public class CavaloXadrez {
    // Instanciando o valor referente ao tamanho do tabuleiro
    private static final int N = 8;

    // Definindo os movimentos que o cavalo pode fazer
    private static final int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        result();
    }

    // solução dos movimentos do cavalo
    public static void result(){
        // criando o tabuleiro
        int[][] tabuleiro = new int[N][N];

        // iniciando o tabuleiro com posição -1, para indicar que as casas ainda não foram visitadas 
        for(int x = 0; x< N; x ++){
            for(int y = 0; y < N; y++){
                tabuleiro[x][y] = -1;
            }
         }

        // Definindo a posição do cavalo
        int startX = 0, startY = 0;
         tabuleiro[startX][startY] = 0; // colocando o cavalo na casa 0 do tabuleiro 

         // recursão dos movimentos do cavalo
         if (!movimentaCavalo(startX, startY,1, tabuleiro)) {
            System.out.println("Solução não encontrada");      
         }else{
            mostrar(tabuleiro);
         }
    }


    // Método de movimento do cavalo
    private static boolean movimentaCavalo(int x, int y, int movei, int[][] tabuleiro) {
     if (movei == N*N) {
        return true; // marca quando a casa é visitada pela ondem
                        // o maximo de casas é de 64 em um tabulerio 8x8
        
     }
     // Tenta os movimentos a partir da posição que esta
     for(int move = 0; move < 8; move++){
        int nextX = x + moveX[move];
        int nextY = y + moveY[move];

        if(casaLimpa(nextX, nextY, tabuleiro)){
            tabuleiro[nextX][nextY] = movei; // quando a casa for visita retorna isso para ser registrada 

            if (movimentaCavalo(nextX, nextY, movei + 1, tabuleiro)) { // chama ela novamente para procurar a proxima movimentação
                return true;
            }else {
                tabuleiro[nextX][nextY] = -1;  // Backtrack
            }
        }
     }
     return false;
    }
    
    // Analisa se é possivel fazer a movimentação
    private static boolean casaLimpa(int x, int y, int[][] tabuleiro) {
        return(x>=0 && x < N && y >= 0 && y < N && tabuleiro[x][y] == -1);
    }

    private static void mostrar(int[][] tabuleiro) {
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                System.out.print(tabuleiro[x][y] + "\t");
            }
            System.out.println(); 
        }
    }

}
