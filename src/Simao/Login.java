package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    public static boolean escolherUtilizador(Scanner sc) throws FileNotFoundException {
        while (true) {
            System.out.print("\n\uD83C\uDFAC Enter user role (ADMIN || CLIENT): ");
            String tipoUtilizador = sc.nextLine();

            if (tipoUtilizador.equalsIgnoreCase("admin")) {
                while (!loginAdmin(sc)) {
                    System.out.println("\n\u274C Invalid username or password. Please try again.\n");
                }
                return true;

            } else if (tipoUtilizador.equalsIgnoreCase("client")) {
                registoCliente(sc);

                String caminhoFilmes = "IMDV/IMDV.csv";
                String caminhoQuiz = "IMDV/IMDV_Quiz2.csv";
                String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);
                Menu_Cliente.menuCliente(matriz, caminhoFilmes);

                return true;

            } else {
                System.out.println("\u274C Invalid user type. Please try again.");
                // repete o ciclo
            }
        }
    }


    public static boolean loginAdmin(Scanner sc) throws FileNotFoundException {
        System.out.print("\uD83D\uDE0E Username: ");
        String username = sc.nextLine();

        System.out.print("\uD83D\uDD12 Password: ");
        String password = sc.nextLine();

        if (validarAcessoAdmin(username, password)) {
            System.out.println("\n*-*-*-*-*-* LOGIN SUCCESSFUL *-*-*-*-*-*");
            return true;
        } else {

            return false;
        }
    }


    public static boolean validarAcessoAdmin(String username, String password) throws FileNotFoundException {
        String caminhoFicheiro = "IMDV/IMDV_AdminLogin.csv";
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            if (linhaSeparada.length == 2) {
                String usernameFicheiro = linhaSeparada[0];
                String passwordFicheiro = linhaSeparada[1];

                if (username.equals(usernameFicheiro) && password.equals(passwordFicheiro)) {
                    sc.close();

                    return true;
                }
            }

        }
        sc.close();
        return false;
    }


    public static void registoCliente(Scanner sc) throws FileNotFoundException {

        System.out.println("\n*_*_*_*_*_* CREATE ACCOUNT *_*_*_*_*_*\n");

        System.out.print("\uD83D\uDC64 Name: ");
        String nome = sc.nextLine();

        System.out.print("\uD83D\uDCDE Phone Number: ");
        String contacto = sc.nextLine();

        System.out.print("\u2709 Email: ");
        String email = sc.nextLine();

        // Apresentar mensagem de sucesso e os dados inseridos pelo utilizador
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.println("\u2705 Successfully registered: " + nome + " | " + contacto + " | " + email);
        System.out.println("-------------------------------------------------------------------------------\n");
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        escolherUtilizador(sc);

        sc.close();
    }
}



