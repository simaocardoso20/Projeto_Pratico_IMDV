import java.util.Scanner;

public class Novo_Registo {


    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner scanner = new Scanner(System.in);

        // Declarar as variáveis
        String userName, email;
        int contact;

        // Perguntar ao utilizador
        System.out.println("*_*_*_*_*_* Registar Utilizador *_*_*_*_*_*");

        System.out.print("Insira nome: ");
        userName = scanner.nextLine();

        System.out.print("Insira contacto: ");
        contact = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Insira email: ");
        email = scanner.nextLine();

        // Apresentar mensagem de sucesso e os dados inseridos pelo utilizador
        System.out.println("\n------------------------------");
        System.out.println("Utilizador Inserido com Sucesso: " + userName + " | " + contact + " | " + email);
        System.out.println("--------------------------------");
    }
}