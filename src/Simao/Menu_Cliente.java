package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Simao.Menu_Admin.listaParaMatriz;

public class Menu_Cliente {


    public static void menu(String[][] matriz, String caminho) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n\n_*_*_*_*_*_*_*_*_*_ TOP MOVIES _*_*_*_*_*_*_*_*_*_");
            System.out.println("1. Consultar a lista de filmes");
            System.out.println("2. Escolher a arte gráfica de um filme ");
            System.out.println("3. Visualizar o melhor Estúdio ");
            System.out.println("4. Visualizar o pior Estúdio ");
            System.out.println("5. Visualizar o review mais recente ");
            System.out.println("6. Jogar um Quiz ");
            System.out.println("7. Escolher um Estúdio ");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("\n_*_*_*_*_*_ The Best Movies Ever _*_*_*_*_*_ \n");
                    Menu_Admin.imprimirMatriz(matriz);
                    break;

                case 2:
                    int opcaoMenuArtes;

                    do {
                        System.out.println("_*_*_*_*_*_ Arte Gráfica de Filmes _*_*_*_*_*_ ");
                        System.out.println("1. Harry Potter");
                        System.out.println("2. Interstellar");
                        System.out.println("3. Lord Of The Rings");
                        System.out.println("4. Star Wars");
                        System.out.println("5. Voltar ao menu inicial");
                        System.out.print("Opção: ");
                        opcaoMenuArtes = input.nextInt();
                        input.nextLine(); // Limpar o buffer

                        String caminhoArte = "";

                        switch (opcaoMenuArtes) {
                            case 1: caminhoArte = "IMDV/CatalogoGrafico/HarryPotter.txt"; break;
                            case 2: caminhoArte = "IMDV/CatalogoGrafico/Interstellar.txt"; break;
                            case 3: caminhoArte = "IMDV/CatalogoGrafico/LordOfTheRings.txt"; break;
                            case 4: caminhoArte = "IMDV/CatalogoGrafico/StarWars.txt"; break;
                            case 5: System.out.println("Voltando ao menu principal..."); break;
                            default: System.out.println("Opção inválida. Tente novamente."); break;
                        }

                        if (!caminhoArte.isEmpty()) {
                            mostrarArteTxt(caminhoArte);
                        }

                    } while (opcaoMenuArtes != 5);

                    break;



                    break;

                case 3:



                    break;

                case 4:

                    break;

                case 5:


                    break;
                case 6:


                    break;
                case 7:


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

        String[][] matriz = Menu_Admin.listaParaMatriz(caminho);

        menu(matriz, caminho);

    }
}
