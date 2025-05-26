package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu_Admin {

    /**
     * Função que serve para imprimir na consola o ficheiro com a lista dos filmes.
     * @param caminhoListaFilmes Caminho para o ficheiro CSV que contém a lista com os dados dos filmes.
     * @throws FileNotFoundException Se o ficheiro externo (IMDV.csv) não for encontrado.
     */
    public static void imprimirFicheiro(String caminhoListaFilmes) throws FileNotFoundException {

        File ficheiro = new File(caminhoListaFilmes);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }

    }



    /**
     * Função que lê o ficheiro CSV linha a linha até ao final e converte-o numa matriz completa com 8 colunas.
     * @param caminhoFilmes Caminho para o ficheiro CSV que contém a lista com os dados dos filmes.
     * @return Devolve uma matriz de Strings, em que cada linha corresponde a um filme e cada coluna a um dos seus 8 atributos.
     * @throws FileNotFoundException Se o ficheiro externo (IMDV.csv) não for encontrado.
     */
    public static String[][] listaParaMatriz(String caminhoFilmes) throws FileNotFoundException {

        File ficheiro = new File(caminhoFilmes);
        Scanner sc = new Scanner(ficheiro);

        // contagem de linhas.
        int contagemLinhas = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }
        sc.close();

        // Criar a matriz com o tamanho certo com 8 colunas.
        String[][] matrizCompleta = new String[contagemLinhas][8];

        // Ler de novo o ficheiro para preencher a matriz.
        sc = new Scanner(ficheiro);

        // Ler linha a linha e dividir a linha nos campos, usando ";" como separador.
        int numFilmeAtual = 0;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            // Copiar cada campo para a respetiva coluna da matriz na linha numFilmeAtual.
            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[numFilmeAtual][i] = linhaSeparada[i];
            }

            numFilmeAtual++;
        }

        sc.close();

        return matrizCompleta;
    }



    /**
     * Função que imprime no ecrã o conteúdo da matriz, ignorando a 1ª coluna.
     * @param matriz com todos os filmes e os seus atributos.
     */
    public static void imprimirMatriz(String[][] matriz) {

        // Removi a 1ª coluna (começar em j=1) porque achei que visualmente tornava a matriz mais confusa para o cliente.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }



    /**
     * Função que imprime uma lista de estúdios da matriz evitando que os mesmos se repitam.
     * @param matriz Matriz de strings, onde cada linha representa um registo (um filme) e a coluna de índice 5 contém o nome dos estúdios.
     */
    public static void imprimirEstudiosUnicos(String[][] matriz) {

        String[] estudiosUnicos = new String[matriz.length];
        int totalUnicos = 0; // Variável que vai guardar o total de estúdios únicos encontrados.

        // Percorrer cada linha da matriz para obter a cada vez o nome do estúdio da coluna 5.
        for (int i = 0; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];
            boolean estudioRepetido = false;

            // Verificar se este estúdio já foi adicionado ao array.
            for (int contador = 0; contador < totalUnicos; contador++) {
                if (estudiosUnicos[contador].equals(estudioAtual)) {
                    estudioRepetido = true;
                    break;
                }
            }
            // Se não estiver repetido, adicionar ao array e incrementar o contador.
            if (!estudioRepetido) {
                estudiosUnicos[totalUnicos] = estudioAtual;
                totalUnicos++;
            }
        }
        // Imprimir a lista de estúdios únicos encontrados.
        for (int i = 0; i < totalUnicos; i++) {
            System.out.println("> " +estudiosUnicos[i]);
        }
    }



    /**
     *  Função que permite aceder a várias funcionalidades do programa através de um menu exclusivo para o administrador.
     * @param matriz Matriz onde cada linha representa um filme e cada coluna contém diferentes atributos sobre os filmes em análise.
     * @param caminhoFilmes Caminho para o ficheiro CSV que contém os dados dos filmes.
     * @throws FileNotFoundException Se algum ficheiro externo (IMDV/IMDV.csv) não for encontrado.
     */
    public static void menuAdmin(String[][] matriz, String caminhoFilmes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {
            // De forma a ser criativo, adicionei ícones (códigos Unicode) relacionados com o tema cinema.
            System.out.println("\n\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC THE MOVIE UNIVERSE IMDV \uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\n");
            System.out.println("\u2B50 1. Movie List");
            System.out.println("\uD83D\uDCAC 2. Total Ratings");
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
                    System.out.println("\uD83D\uDCAC\uD83D\uDCAC\uD83D\uDCAC\uD83D\uDCAC TOTAL RATINGS \uD83D\uDCAC\uD83D\uDCAC\uD83D\uDCAC\uD83D\uDCAC\n");
                    // Removi a 1ª linha da matriz que é o cabeçalho para não ser contabilizado no total de ratings, uma vez que cada rating corresponde a uma linha da matriz.
                    int totalRatings = matriz.length - 1;
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("      \u2B50 " + totalRatings + " Ratings" + " \u2B50");
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    break;

                case 3:

                    System.out.println("\uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5 STUDIOS LIST \uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5\uD83C\uDFA5\n");

                    imprimirEstudiosUnicos(matriz);

                    break;


                case 0:
                    System.out.println("              \uD83D\uDE0A\uD83D\uDE0A BYE! COME BACK SOON! \uD83D\uDE0A\uD83D\uDE0A");
                    imprimirFicheiro("IMDV/IMDV_Copyright.txt");
                    System.exit(0); // Tive que usar este código porque sempre que fechava o programa, ele entrava no menu do Cliente.
                    break;

                default:
                    System.out.println("\u26D4 INVALID OPTION \u26D4");

                    break;

            }

        } while (opcao != 0);
    }



    /**
     * Este metodo carrega uma lista de filmes a partir de um ficheiro CSV, converte-o para uma matriz bidimensional e inicia o menu destinado ao administrador.
     * @param args Argumentos da linha de comandos.
     * @throws FileNotFoundException Se o ficheiro IMDV/IMDV.csv não for encontrado.
     */
    public static void main(String[] args) throws FileNotFoundException {

        String caminhoListaFilmes = "IMDV/IMDV.csv";
        String[][] matriz = listaParaMatriz("IMDV/IMDV.csv");

        menuAdmin(matriz, caminhoListaFilmes);
    }
}


