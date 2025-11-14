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

    public static void limparTerminal() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception exception) {
            // Lidar com a exceção
        }
    }

    public static void posicionarNavioUsuario(String[][] tabuleiro, String nomeNavio, int tamanho) {
        Scanner sc = new Scanner(System.in);
        int linha, coluna, direcao;
        int tamanho_tabuleiro = tabuleiro.length;
        boolean sucesso = false;

        while (sucesso == false) {
            System.out.println("Posicione o navio: " + nomeNavio + " (tamanho " + tamanho + ")");

            System.out.println("Digite a linha (0 - " + (tamanho_tabuleiro - 1) + "): ");
            linha = sc.nextInt();

            System.out.println("Digite a coluna (0 - " + (tamanho_tabuleiro - 1) + "): ");
            coluna = sc.nextInt();

            System.out.println("Escolha a direção:\n0 = horizontal,\n1 = vertical,\n2 = diagonal,\n3 = diagonal");
            System.out.print("Digite a direção: ");
            direcao = sc.nextInt();

            if (linha < 0 || linha >= tamanho_tabuleiro || coluna < 0 || coluna >= tamanho_tabuleiro || direcao < 0 || direcao > 3) {
                System.out.println("Entrada inválida! Tente novamente.\n");
                continue;
            }

            if (direcao == 0) {
                if (coluna + tamanho > tamanho_tabuleiro) {
                    System.out.println("O navio nao cabe no tabuleiro!");
                    continue;
                }
            }
            if (direcao == 1) {
                if (linha + tamanho > tamanho_tabuleiro) {
                    System.out.println("O navio nao cabe no tabuleiro!");
                    continue;
                }
            }
            if (direcao == 2) {
                if (linha + tamanho > tamanho_tabuleiro || coluna + tamanho > tamanho_tabuleiro) {
                    System.out.println("O navio nao cabe no tabuleiro!");
                    continue;
                }
            }
            if (direcao == 3) {
                if (linha + tamanho > tamanho_tabuleiro || coluna - tamanho < 0) {
                    System.out.println("==================================");
                    System.out.println("\nO navio nao cabe no tabuleiro!");
                    System.out.println("Nao foi possivel posicionar" + nomeNavio);
                    System.out.println("Tente novamente!");
                    System.out.println("==================================");
                    continue;
                }
            }

            int linha2 = linha;
            int coluna2 = coluna;
            boolean podeColocar = true;

            if (direcao == 0) {
                for (int i = 0; i < tamanho; i++) {
                    if (tabuleiro[linha2][coluna2] != "~") {
                        System.out.println("\n==================================");
                        System.out.println("O navio nao cabe no tabuleiro!");
                        System.out.println("Nao foi possivel posicionar: " + nomeNavio);
                        System.out.println("Tente novamente!");
                        System.out.println("==================================\n");
                        podeColocar = false;
                        break;
                    } else {
                        coluna2 += 1;
                    }
                }
            }

            if (direcao == 1) {
                for (int i = 0; i < tamanho; i++) {
                    if (tabuleiro[linha2][coluna2] != "~") {
                        System.out.println("\n==================================");
                        System.out.println("O navio nao cabe no tabuleiro!");
                        System.out.println("Nao foi possivel posicionar: " + nomeNavio);
                        System.out.println("Tente novamente!");
                        System.out.println("==================================\n");
                        podeColocar = false;
                        break;
                    } else {
                        linha2 += 1;
                    }
                }
            }

            if (direcao == 2) {
                for (int i = 0; i < tamanho; i++) {
                    if (tabuleiro[linha2][coluna2] != "~") {
                        System.out.println("\n==================================");
                        System.out.println("O navio nao cabe no tabuleiro!");
                        System.out.println("Nao foi possivel posicionar: " + nomeNavio);
                        System.out.println("Tente novamente!");
                        System.out.println("==================================\n");
                        podeColocar = false;
                        break;
                    } else {
                        linha2 += 1;
                        coluna2 += 1;
                    }
                }
            }

            if (direcao == 3) {
                for (int i = 0; i < tamanho; i++) {
                    if (tabuleiro[linha2][coluna2] != "~") {
                        System.out.println("\n==================================");
                        System.out.println("O navio nao cabe no tabuleiro!");
                        System.out.println("Nao foi possivel posicionar: " + nomeNavio);
                        System.out.println("Tente novamente!");
                        System.out.println("==================================\n");
                        podeColocar = false;
                        break;
                    } else {
                        linha2 += 1;
                        coluna2 -= 1;
                    }
                }
            }

            if (podeColocar == false){
                continue;
            }

            int coluna3 = coluna;
            int linha3 = linha;


            if (direcao == 0) {
                for (int i = 0; i < tamanho; i++) {
                    tabuleiro[linha][coluna3] = "N";
                    coluna3 += 1;
                }
            }

            if (direcao == 1) {
                for (int i = 0; i < tamanho; i++) {
                    tabuleiro[linha3][coluna] = "N";
                    linha3 += 1;
                }
            }

            if (direcao == 2) {
                for (int i = 0; i < tamanho; i++) {
                    tabuleiro[linha3][coluna3] = "N";
                    coluna3 += 1;
                    linha3 += 1;
                }
            }

            if (direcao == 3) {
                for (int i = 0; i < tamanho; i++) {
                    tabuleiro[linha3][coluna3] = "N";
                    coluna3 -= 1;
                    linha3 += 1;
                }
            }

            sucesso = true;
        }
        limparTerminal();
    }

    public static void realizarAtaque(String[][] tabuleiro_real, String[][] tabuleiro_vazio){
        Scanner sc = new Scanner(System.in);
        int tamanho_tabuleiro = tabuleiro_real.length;
        int linha, coluna, tentativas=0;
        boolean fim = false;
        System.out.println("\n================================================\n");
        exibirTabuleiro(tabuleiro_vazio);
        while (fim == false){

            System.out.println("Digite a linha do ponto que voce deseja atacar (0-9): ");
            linha = sc.nextInt();
            System.out.println("Digite a coluna do ponto que voce deseja atacar(0-9): ");
            coluna = sc.nextInt();


            if (linha < 0 || linha >= tamanho_tabuleiro || coluna < 0 || coluna >= tamanho_tabuleiro) {
                System.out.println("Entrada inválida! Tente novamente.\n");
                continue;
            }

            if (tabuleiro_vazio[linha][coluna].equals("X") || tabuleiro_vazio[linha][coluna].equals("O")) {
                System.out.println("Você já atacou esse ponto! Escolha outro.");
                continue;
            }
            tentativas++;

            if (tabuleiro_real[linha][coluna] == "~"){
                System.out.println("Voce errou!");
                tabuleiro_real[linha][coluna] = "O";
                tabuleiro_vazio[linha][coluna] = "O";
                exibirTabuleiro(tabuleiro_vazio);
            }
            if (tabuleiro_real[linha][coluna] == "N"){
                System.out.println("Voce acertou um navio!");
                tabuleiro_real[linha][coluna] = "X";
                tabuleiro_vazio[linha][coluna] = "X";
                exibirTabuleiro(tabuleiro_vazio);
            }
        }
        fim = true;
    }



    static void main() {
        Scanner sc = new Scanner(System.in);
        String[][] tabuleiro_navios = inicializarTabuleiro(10);
        String[][] tabuleiro_vazio = inicializarTabuleiro(10);
        preencherTabuleiro(tabuleiro_navios);
        preencherTabuleiro(tabuleiro_vazio);

        posicionarNavioUsuario(tabuleiro_navios, "Porta Navios", 4);
        exibirTabuleiro(tabuleiro_navios);
        posicionarNavioUsuario(tabuleiro_navios, "Fragata", 3);
        exibirTabuleiro(tabuleiro_navios);
        posicionarNavioUsuario(tabuleiro_navios, "Submarino", 2);
        exibirTabuleiro(tabuleiro_navios);
        posicionarNavioUsuario(tabuleiro_navios, "Bote", 1);
        exibirTabuleiro(tabuleiro_navios);
        limparTerminal();

        realizarAtaque(tabuleiro_navios, tabuleiro_vazio);

    }
}
