package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu_Admin {


    public static int contarLinhas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contagemLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }

        sc.close();

        return contagemLinhas;

    }

    // Imprimir ficheiro lista de filmes
    public static void imprimirFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }

    }


    public static String[][] listaParaMatriz(String matriz) throws FileNotFoundException {

        // Retirar linha do cabeçalho
        int listaFilmes = contarLinhas(matriz) -1;

        // Criar uma matriz com o tamanho certo
        String[][] matrizCompleta = new String[listaFilmes][8];

        // Criar as ferramentas de leitura
        File ficheiro = new File(matriz);
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

        for (int i = 0; i < matriz.length; i++) {
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


        System.out.println("\nEstúdios encontrados:");
        for (int i = 0; i < totalUnicos; i++) {
            System.out.println("> " +estudiosUnicos[i]);
        }
    }



    public static void menu(String[][] matriz, String caminho) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\n_*_*_*_*_*_*_*_*_*_ TOP MOVIES _*_*_*_*_*_*_*_*_*_");
            System.out.println("1. Consultar a lista TOP Movies");
            System.out.println("2. Visualizar total de Ratings");
            System.out.println("3. Visualizar todos os estúdios");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("_*_*_*_*_*_ The Best Movies Ever _*_*_*_*_*_ ");
                    imprimirFicheiro(caminho);

                    break;

                case 2:
                    System.out.println("_*_*_*_*_*_ Total de Ratings _*_*_*_*_*_ ");

                    int totalRatings = matriz.length;
                    System.out.println("> " + totalRatings);

                    break;

                case 3:

                    System.out.println("_*_*_*_*_*_ Lista de Estúdios _*_*_*_*_*_ ");

                    imprimirEstudiosUnicos(matriz);


                    break;


                case 0:
                    System.out.println("_*_*_*_*_*_ Encerrar o Programa _*_*_*_*_*_ ");
                    break;

                default:
                    System.out.println("!!!!!!!!!!! Opção Inválida !!!!!!!!!!!");
                    break;

            }

        } while (opcao != 0);
    }


    //Main
    public static void main(String[] args) throws FileNotFoundException {

        String caminho = "IMDV/IMDV.csv";
        String[][] matriz = listaParaMatriz("IMDV/IMDV.csv");

        imprimirFicheiro(caminho);

        menu(matriz, caminho);




    }
}


