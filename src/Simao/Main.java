package Simao;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    /**
     * Metodo principal que inicia o programa e gere o fluxo inicial com base no tipo de utilizador (ADMIN or CLIENT).
     * @param args Argumentos da linha de comandos (não são utilizados neste programa).
     * @throws FileNotFoundException Caso algum dos ficheiros necessários (como IMDV/IMDV.csv) não seja encontrado.
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        // Se for Admin apresento o menu do Admin.
        if (Login.escolherUtilizador(sc)) {
            String caminhoFilmes = "IMDV/IMDV.csv";
            String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);
            Menu_Admin.menuAdmin(matriz, caminhoFilmes);

        } else {

         // caso contrário apresento o menu do cliente.
            String caminhoFilmes = "IMDV/IMDV.csv";
            String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);
            Menu_Cliente.menuCliente(matriz, caminhoFilmes);
        }

        sc.close();
    }
}
