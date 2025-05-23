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


    public static String[][] listaParaMatriz(String caminho) throws FileNotFoundException {

        // Saber quantos filmes tem o ficheiro (retirar o cabeçalho (-1))
        int numeroFilmes = contarLinhas(caminho);

        // Criar uma matriz com o tamanho certo
        String[][] matrizCompleta = new String[numeroFilmes][8];

        // Criar as ferramentas de leitura
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Controlar o numero de filmes
        int numFilmeAtual = 0;

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
        System.out.println("\n========== Top Movies ==============");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println("=====================================");
    }


    public static void menu(String[][] matriz) {

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


                    break;

                case 2:
                    System.out.println("_*_*_*_*_*_ Pesquisar por Artista _*_*_*_*_*_ ");


                    break;

                case 3:
                    System.out.println("_*_*_*_*_*_ Música Mais Longa _*_*_*_*_*_ ");

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

        String caminhoCSV = "IMDV/IMDV.csv";
        String[][] matriz = listaParaMatriz("IMDV/IMDV.csv");
        imprimirMatriz(matriz);

    }
}


