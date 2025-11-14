import java.util.Scanner;

public class Trabalho {

    public static String[][] inicializarTabuleiro(int a) {
        String[][] tabuleiro = new String[a][a];
        return tabuleiro;
    }

    public static String[][] preencherTabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiro[i][j] = "~";
            }
        }
        return tabuleiro;
    }

    public static void exibirTabuleiro(String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("[");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j != tabuleiro[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("],");
        }
    }

    public static boolean posicionarNavioUsuario(String[][] tabuleiro, int tamanho, String nomeNavio) {
        Scanner sc = new Scanner(System.in);
        int linha, coluna, direcao;
        int n = tabuleiro.length;
        boolean sucesso = false;

        while (!sucesso){
            System.out.println("Posicione o navio: " + nomeNavio + " (tamanho " + tamanho + ")");

            System.out.println("Digite a linha (0 - " + (n-1) + "): ");
            linha = sc.nextInt();

            System.out.println("Digite a coluna (0 - " + (n-1) + "): ");
            coluna = sc.nextInt();

            System.out.println("Escolha a direção: 0 = horizontal →, 1 = vertical ↓, 2 = diagonal ↘, 3 = diagonal ↙");
            System.out.print("Digite a direção: ");
            direcao = sc.nextInt();

            if (linha < 0 || linha >= n || coluna < 0 || coluna >= n || direcao < 0 || direcao > 3) {
                System.out.println("Entrada inválida! Tente novamente.\n");
                continue;
            }

        }
    }

        static void main () {
            Scanner sc = new Scanner(System.in);
            String[][] tabuleiro_navios = inicializarTabuleiro(10);
            preencherTabuleiro(tabuleiro_navios);

            exibirTabuleiro(tabuleiro_navios);


        }
}

