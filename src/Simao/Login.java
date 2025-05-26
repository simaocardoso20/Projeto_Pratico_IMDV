package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    /**
     * Função que faculta a escolha do tipo de utilizador (ADMIN or CLIENT) e executa o fluxo correspondente com base na escolha.
     * @param sc sc Scanner utilizado para ler a entrada do utilizador.
     * @return true quando a escolha do utilizador é validada e o sistema avança com a operação correspondente.
     * @throws FileNotFoundException Se os ficheiros externos (IMDV/IMDV.csv e IMDV_Quiz2.csv) não forem encontrados.
     */
    public static boolean escolherUtilizador(Scanner sc) throws FileNotFoundException {
        while (true) {
            System.out.print("\n\uD83C\uDFAC Enter user role (ADMIN || CLIENT): ");
            String tipoUtilizador = sc.nextLine();

            // Se o utilizador escreveu "admin", chama a função loginAdmin(sc). Enquanto o login for inválido, repete.
            if (tipoUtilizador.equalsIgnoreCase("admin")) {
                while (!loginAdmin(sc)) {
                    System.out.println("\n\u274C Invalid username or password. Please try again.\n");
                }
                return true;

            // Se o utilizador escreveu "client", Chamo a função registoCliente(sc) para recolher nome, email e contacto e entramos no menu Cliente.
            } else if (tipoUtilizador.equalsIgnoreCase("client")) {
                registoCliente(sc);

                String caminhoFilmes = "IMDV/IMDV.csv";
                String caminhoQuiz = "IMDV/IMDV_Quiz2.csv";
                String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);
                Menu_Cliente.menuCliente(matriz, caminhoFilmes);

                return true;

            } else {
                // Se o utilizador não escreveu nem Admin ou Client, falha e pede para repetir.
                System.out.println("\u274C Invalid user type. Please try again.");
            }
        }
    }


    /**
     * Função que solicita ao utilizador, neste caso o Administrador, as suas credenciais (username e password) e valida o acesso
       com base nos dados inseridos.
     * @param sc sc Scanner utilizado para ler a entrada do utilizador.
     * @return true se o username e a password forem válidos e a autenticação for bem-sucedida e false caso se verifique o contrário.
     * @throws FileNotFoundException Se o ficheiro externo (IMDV/IMDV_AdminLogin.csv) não for encontrado.
     */
    public static boolean loginAdmin(Scanner sc) throws FileNotFoundException {

        // Solicito ao Administrador para inserir as suas credenciais.
        System.out.print("\uD83D\uDE0E Username: ");
        String username = sc.nextLine();

        System.out.print("\uD83D\uDD12 Password: ");
        String password = sc.nextLine();

        // Chamo a função "validarAcessoAdmin", essa função procura no ficheiro se existe uma linha com as credenciais inseridas pelo Administrador.
        // Se forem válidas, mostra uma mensagem de sucesso e continua, caso contrário falha o login.
        if (validarAcessoAdmin(username, password)) {
            System.out.println("\n*-*-*-*-*-* LOGIN SUCCESSFUL *-*-*-*-*-*");
            return true;

        } else {

            return false;
        }
    }


    /**
     * Função que valida o acesso de um administrador comparando as credenciais inseridas na consola com as armazenadas num ficheiro CSV.
     * @param username O nome de utilizador inserido pelo administrador.
     * @param password A palavra-passe inserida pelo administrador.
     * @return true se as credenciais inseridas coincidirem com as que estão no ficheiro e false caso se verifique o contrário.
     * @throws FileNotFoundException Se o ficheiro externo (IMDV/IMDV_AdminLogin.csv) não for encontrado.
     */
    public static boolean validarAcessoAdmin(String username, String password) throws FileNotFoundException {

        String caminhoFicheiro = "IMDV/IMDV_AdminLogin.csv";
        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);


        // Lê o ficheiro "IMDV/IMDV_AdminLogin.csv" linha a linha e divide a linha onde encontrar um ";"
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

        // Garante que a linha tenha apenas dois campos e separa o username da password.
            if (linhaSeparada.length == 2) {
                String usernameFicheiro = linhaSeparada[0];
                String passwordFicheiro = linhaSeparada[1];

        // Compara o que o utilizador inseriu na consola com os dados do ficheiro. Se os dados coincidirem, retorna true (Login bem-sucedido).
                if (username.equals(usernameFicheiro) && password.equals(passwordFicheiro)) {
                    sc.close();

                    return true;
                }
            }

        }
        sc.close();
        return false;
    }


    /**
     * Função que solicita ao cliente a inserção dos seus dados pessoais (nome, contacto e email) para poder efetuar o registo.
     * @param sc sc Scanner utilizado para ler a entrada do utilizador a partir da consola.
     */
    public static void registoCliente(Scanner sc) {

        System.out.println("\n*_*_*_*_*_* CREATE ACCOUNT *_*_*_*_*_*\n");

        // É solicitado ao cliente a inserção dos seus dados pessoais.
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


    /**
     * Metodo que permite ler a entrada do utilizador via consola e chama o metodo "escolherUtilizador" para iniciar o processo de login/registo,
       consoante o tipo de utilizador (ADMIN or CLIENT).
     * @param args args Argumentos da linha de comandos (não são utilizados neste programa).
     * @throws FileNotFoundException Caso ocorra um erro ao tentar aceder a um dos ficheiro necessário durante o processo de login ou carregamento de dados.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        escolherUtilizador(sc);

        sc.close();
    }
}



