package Simao;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        if (Login.escolherUtilizador(sc)) {
         // Se for Admin apresento o menu do Admin
            String caminhoFilmes = "IMDV/IMDV.csv";
            String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);
            Menu_Admin.menuAdmin(matriz, caminhoFilmes);

        } else {

         // caso contrário apresento o menu do cliente
            String caminhoFilmes = "IMDV/IMDV.csv";
            String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);
            Menu_Cliente.menuCliente(matriz, caminhoFilmes);
        }

        sc.close();
    }
}
