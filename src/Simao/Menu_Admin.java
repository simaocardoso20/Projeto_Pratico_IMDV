package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu_Admin {


    public static int contarLinhas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Como vou usar esta função e não preciso do cabeçalho, peço para a passar à frente a 1ª linha para depois poder entrar num ciclo while.
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        int contagemLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }

        sc.close();

        return contagemLinhas;

    }

    // Imprimir ficheiro lista de filmes
    public static void imprimirFicheiro(String caminhoListaFilmes) throws FileNotFoundException {

        File ficheiro = new File(caminhoListaFilmes);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }

    }


    public static String[][] listaParaMatriz(String caminhoFilmes) throws FileNotFoundException {

        // Retirar linha do cabeçalho
        int listaFilmes = contarLinhas(caminhoFilmes);

        // Criar uma matriz com o tamanho certo
        String[][] matrizCompleta = new String[listaFilmes][8];

        // Criar as ferramentas de leitura
        File ficheiro = new File(caminhoFilmes);
        Scanner sc = new Scanner(ficheiro);

        // Controlar o numero de filmes
        int numFilmeAtual = 0;

        sc.nextLine();

        // Ler o ficheiro linha à linha
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[numFilmeAtual][i] = linhaSeparada[i];
            }

            // Adicionar um filme a atual variável
            numFilmeAtual++;

        }

        sc.close();


        // Devolve a matriz com o conteúdo do ficheiro
        return matrizCompleta;
    }

    // Imprimir matriz
    public static void imprimirMatriz(String[][] matriz) {

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }


    // Guardar em memória os estúdios da matriz evitando repetições
    public static void imprimirEstudiosUnicos(String[][] matriz) {

        String[] estudiosUnicos = new String[matriz.length];
        int totalUnicos = 0;

        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];
            boolean estudioRepetido = false;

            for (int contador = 0; contador < totalUnicos; contador++) {
                if (estudiosUnicos[contador].equals(estudioAtual)) {
                    estudioRepetido = true;
                    break;
                }
            }

            if (!estudioRepetido) {
                estudiosUnicos[totalUnicos] = estudioAtual;
                totalUnicos++;
            }
        }

        for (int i = 0; i < totalUnicos; i++) {
            System.out.println("> " +estudiosUnicos[i]);
        }
    }



    public static void menuAdmin(String[][] matriz, String caminhoFilmes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC THE MOVIE UNIVERSE IMDV \uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\n");
            System.out.println("\u2B50 1. Movie List");
            System.out.println("\uD83D\uDCDD 2. Total Ratings");
            System.out.println("\uD83C\uDFA5 3. Studios list");
            System.out.println("\u274C 0. Exit\n");

            System.out.print("> Select an option: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("\u2B50\u2B50\u2B50\u2B50 MOVIE LIST \u2B50\u2B50\u2B50\u2B50\n");
                    imprimirFicheiro(caminhoFilmes);

                    break;

                case 2:
                    System.out.println("\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD TOTAL RATINGS \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\n");

                    int totalRatings = matriz.length;
                    System.out.println("> " + totalRatings + "Ratings.");

                    break;

                case 3:

                    System.out.println("\uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5 STUDIOS LIST \uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5\n");

                    imprimirEstudiosUnicos(matriz);

                    break;


                case 0:
                    System.out.println("              \uD83D\uDE0A\uD83D\uDE0A BYE! COME BACK SOON! \uD83D\uDE0A\uD83D\uDE0A");
                    imprimirFicheiro("IMDV/IMDV_Copyright.txt");

                    break;

                default:
                    System.out.println("\u26D4 INVALID OPTION \u26D4");

                    break;

            }

        } while (opcao != 0);
    }


    //Main
    public static void main(String[] args) throws FileNotFoundException {

        String caminhoListaFilmes = "IMDV/IMDV.csv";
        String[][] matriz = listaParaMatriz("IMDV/IMDV.csv");

        menuAdmin(matriz, caminhoListaFilmes);
    }
}


