package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Simao.Menu_Admin.listaParaMatriz;

public class Menu_Cliente {

    public static void melhorRating(String[][] matriz) {

        // A variável melhorMedia inicia a 0. Uma vez que todos os ratings são maiores do que 0, as médias também elas serão superiores e
        // poderão assim ser comparadas da pior para a melhor.
        String melhorEstudio = matriz[1][5];
        double melhorMedia = 0;

        // Para cada estúdio na matriz
        for (int i = 1; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];

            // Calcular média deste estúdio
            double somaRatings = 0;
            int totalFilmes = 0;

            // O ciclo começa na linha 1 (o cabeçalho é a linha 0) e percorre toda a matriz. Se naquela linha, na coluna 5,
            // o estúdio for igual ao estúdio atual, então ele converte o rating que está como String para Double e adiciona a soma total.
            // Por último, o contador aumenta o nº de filmes daquele estúdio.
            // O ciclo repete-se até que o nº total de linhas da matriz seja igual ao nº atual da linha a ser lida (j).

            for (int j = 1; j < matriz.length; j++) {
                if (matriz[j][5].equals(estudioAtual)) {
                    somaRatings += Double.parseDouble(matriz[j][2]);
                    totalFilmes++;
                }
            }

            double mediaAtual = somaRatings / totalFilmes;

            // Se a média actual for maior, substituir o valor da melhor média pela média atual e substituir o melhor estúdio pelo estúdio atual.
            if (mediaAtual > melhorMedia) {
                melhorMedia = mediaAtual;
                melhorEstudio = estudioAtual;
            }
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("     " + melhorEstudio + " (Average rating: " + melhorMedia + ")");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }


    public static void piorRating(String[][] matriz)  {

        // Neste caso, a variável melhorMedia inicia a 10. Uma vez que todos os ratings são inferiores a 10, as médias também elas serão inferiores
        // e poderão assim ser comparadas da melhor para a pior.
        String piorEstudio = matriz[1][5];
        double piorMedia = 10;

        // Para cada estúdio na matriz
        for (int i = 1; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];

            // Calcular média deste estúdio
            double somaRatings = 0;
            int totalFilmes = 0;


            for (int j = 1; j < matriz.length; j++) {
                if (matriz[j][5].equals(estudioAtual)) {
                    somaRatings += Double.parseDouble(matriz[j][2]);
                    totalFilmes++;
                }
            }

            double mediaAtual = somaRatings / totalFilmes;

            // Se a média actual for pior, substituir o valor da pior média pela média atual e substituir o pior estúdio pelo estúdio atual.
            if (mediaAtual < piorMedia) {
                piorMedia = mediaAtual;
                piorEstudio = estudioAtual;
            }
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("      " + piorEstudio + " (Average rating: " + piorMedia + ")");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

    }


    public static void ultimoReview(String[][] matriz) {

        // Declarei a variável ultimaLinha para saber qual é a última linha da matriz. Comprimento total de linhas -1.
        int ultimaLinha = matriz.length - 1;

        // Vou imprimir apenas as colunas (nome e rating) assumindo que as colunas da matriz não vão mudar, contudo sempre
        // que adicionarem linhas à matriz, os valores impressos serão atualizados para a última linha (-1).
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("        " + matriz[ultimaLinha][1] + " - " + matriz[ultimaLinha][2]);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }


    public static void Quiz(String caminho) throws FileNotFoundException {

            Scanner ficheiro = new Scanner(new File(caminho));
            Scanner input = new Scanner(System.in);

            int totalpontuacao = 0;
            int totalPerguntas = 0;





    }

// Criação do menu principal para o cliente percorrer
    public static void menu(String[][] matriz, String caminho) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {
            // De forma a ser criativo, adicionei ícones (códigos Unicode) relacionados com o tema cinema.
            System.out.println("\n\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC THE MOVIE UNIVERSE IMDV \uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\n");
            System.out.println("\u2B50 1. Movie List");
            System.out.println("\uD83C\uDFA8 2. Graphic Art");
            System.out.println("\uD83C\uDFC6 3. Best Movie Studio");
            System.out.println("\uD83D\uDC80 4. Worst Movie Studio");
            System.out.println("\uD83D\uDCDD 5. Latest Review");
            System.out.println("\uD83C\uDFB2 6. Play Quiz");
            System.out.println("\uD83C\uDFAD 7. Movie Categories");
            System.out.println("\u274C 0. Exit\n");

            System.out.print("> Select an option: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("\u2B50\u2B50\u2B50\u2B50 MOVIE LIST \u2B50\u2B50\u2B50\u2B50\n");
                    Menu_Admin.imprimirMatriz(matriz);
                    break;

                case 2:
                    int opcaoMenuArtes;

                    // Criação de um submenu para a opção Arte Gráfica
                    do {
                        System.out.println("\n\uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8 MOVIE GRAPHICS \uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8\n");

                        System.out.println("\uD83E\uDDD9\u200D\u2642\uFE0F 1. Harry Potter");
                        System.out.println("\uD83D\uDE80 2. Interstellar");
                        System.out.println("\uD83E\uDDDD\u200D\u2642\uFE0F 3. Lord Of The Rings");
                        System.out.println("\u2728 4. Star Wars");
                        System.out.println("\u274C 5. Back to main menu\n");

                        System.out.print("> Select an option: ");

                        opcaoMenuArtes = input.nextInt();
                        input.nextLine(); // Limpar o buffer

                        String caminhoArte = "";

                        // Associar imagem à opção anterior do cliente
                        switch (opcaoMenuArtes) {
                            case 1: caminhoArte = "IMDV/CatalogoGrafico/HarryPotter.txt"; break;
                            case 2: caminhoArte = "IMDV/CatalogoGrafico/Interstellar.txt"; break;
                            case 3: caminhoArte = "IMDV/CatalogoGrafico/LordOfTheRings.txt"; break;
                            case 4: caminhoArte = "IMDV/CatalogoGrafico/StarWars.txt"; break;
                            case 5: System.out.println("Return to previous menu"); break;
                            default: System.out.println("Invalid option. Please try again."); break;
                        }

                        if (!caminhoArte.isEmpty()) {
                            Menu_Admin.imprimirFicheiro(caminhoArte);
                        }

                    } while (opcaoMenuArtes != 5);

                    break;


                case 3:
                    System.out.println("    \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6  BEST MOVIE STUDIO \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6\n");
                    melhorRating(matriz);

                    break;

                case 4:
                    System.out.println("    \uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80  WORST MOVIE STUDIO \uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\n");
                    piorRating(matriz);

                    break;

                case 5:
                    System.out.println("    \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD LATEST REVIEW \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\n");
                    ultimoReview(matriz);

                    break;
                case 6:


                    break;
                case 7:


                    break;
                case 8:



                case 0:
                    System.out.println("_*_*_*_*_*_ EXIT _*_*_*_*_*_ ");
                    break;

                default:
                    System.out.println("\u26D4 INVALID OPTION \u26D4");
                    break;

            }

        } while (opcao != 0);
    }





    //Main
    public static void main(String[] args) throws FileNotFoundException {

        String caminho = "IMDV/IMDV.csv";

        String[][] matriz = Menu_Admin.listaParaMatriz(caminho);

        // Menu principal do Cliente - The Movie Universe IMDV
        menu(matriz, caminho);

        // Comparar os ratings por estúdio e imprimir o melhor
        melhorRating(matriz);

        // Comparar os ratings por estúdio e imprimir o pior
        piorRating(matriz);

        // Imprimir o último review da matriz
        ultimoReview(matriz);

    }
}
