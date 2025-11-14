import java.util.Scanner;

public class teste {
    public static int[][] criar_tabuleiro(int a){
        int[][] tabuleiro = new int[a][a];
        return tabuleiro;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int[][] tabuleiro_navios = criar_tabuleiro(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(tabuleiro_navios[i][j]);
            }
        }
    }
}
