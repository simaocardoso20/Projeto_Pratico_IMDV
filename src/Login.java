import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    // Login Admin

    public static boolean loginAdmin(Scanner sc) throws FileNotFoundException {
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (validarAcessoAdmin(username, password)) {
            System.out.println("Login efetuado com sucesso.");
            return true;
        } else {
            System.out.println("Username ou Password inválido\n");
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

    // Registar novo cliente

    public static void registarCliente(Scanner sc) throws FileNotFoundException {

            System.out.println("*_*_*_*_*_* Registar Utilizador *_*_*_*_*_*");

            System.out.print("Insira o seu nome: ");
            String nome = sc.nextLine();

            System.out.print("Insira o seu contacto: ");
            String contacto = sc.nextLine();

            System.out.print("Insira o seu email: ");
            String email = sc.nextLine();

            // Apresentar mensagem de sucesso e os dados inseridos pelo utilizador
            System.out.println("\n------------------------------");
            System.out.println("Utilizador Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);
            System.out.println("------------------------------\n");
        }


        public static void main (String[]args) throws FileNotFoundException {


            // Criação do Scanner - Vamos ler inputs do utilizador
            Scanner sc = new Scanner(System.in);

            // Perguntar ao utilizador
            System.out.print("Tipo de Utilizador (ADMIN || CLIENTE): ");
            String tipoUtilizador = sc.nextLine();

            if (tipoUtilizador.equalsIgnoreCase("admin")) {

                while (!loginAdmin(sc)) {
                    System.out.println("O login falhou. Tente novamente.");
                }

            } else if (tipoUtilizador.equalsIgnoreCase("cliente")) {
                registarCliente(sc);

            } else {
                System.out.println("Tipo de utilizador inválido.");
            }


            sc.close();
        }
    }

