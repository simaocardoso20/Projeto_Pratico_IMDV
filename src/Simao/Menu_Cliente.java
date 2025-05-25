package Simao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static Simao.Menu_Admin.listaParaMatriz;

public class Menu_Cliente {

    public static void melhorRating(String[][] matriz) {

        // A variável melhorMedia inicia a 0. Uma vez que todos os ratings são maiores do que 0, as médias também elas serão superiores e
        // poderão assim ser comparadas da pior para a melhor.
        String melhorEstudio = matriz[1][5];
        double melhorMedia = 0;

        // Para cada estúdio na matriz
        for (int i = 1; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];

            // Calcular média deste estúdio
            double somaRatings = 0;
            int totalFilmes = 0;

            // O ciclo começa na linha 1 (o cabeçalho é a linha 0) e percorre toda a matriz. Se naquela linha, na coluna 5,
            // o estúdio for igual ao estúdio atual, então ele converte o rating que está como String para Double e adiciona a soma total.
            // Por último, o contador aumenta o nº de filmes daquele estúdio.
            // O ciclo repete-se até que o nº total de linhas da matriz seja igual ao nº atual da linha a ser lida (j).

            for (int j = 1; j < matriz.length; j++) {
                if (matriz[j][5].equals(estudioAtual)) {
                    somaRatings += Double.parseDouble(matriz[j][2]);
                    totalFilmes++;
                }
            }

            double mediaAtual = somaRatings / totalFilmes;

            // Se a média actual for maior, substituir o valor da melhor média pela média atual e substituir o melhor estúdio pelo estúdio atual.
            if (mediaAtual > melhorMedia) {
                melhorMedia = mediaAtual;
                melhorEstudio = estudioAtual;
            }
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("     " + melhorEstudio + " (Average rating: " + melhorMedia + ")");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    public static void piorRating(String[][] matriz) {

        // Neste caso, a variável melhorMedia inicia a 10. Uma vez que todos os ratings são inferiores a 10, as médias também elas serão inferiores
        // e poderão assim ser comparadas da melhor para a pior.
        String piorEstudio = matriz[1][5];
        double piorMedia = 10;

        // Para cada estúdio na matriz
        for (int i = 1; i < matriz.length; i++) {
            String estudioAtual = matriz[i][5];

            // Calcular média deste estúdio
            double somaRatings = 0;
            int totalFilmes = 0;


            for (int j = 1; j < matriz.length; j++) {
                if (matriz[j][5].equals(estudioAtual)) {
                    somaRatings += Double.parseDouble(matriz[j][2]);
                    totalFilmes++;
                }
            }

            double mediaAtual = somaRatings / totalFilmes;

            // Se a média actual for pior, substituir o valor da pior média pela média atual e substituir o pior estúdio pelo estúdio atual.
            if (mediaAtual < piorMedia) {
                piorMedia = mediaAtual;
                piorEstudio = estudioAtual;
            }
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("      " + piorEstudio + " (Average rating: " + piorMedia + ")");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

    }

    public static void ultimoReview(String[][] matriz) {

        // Declarei a variável ultimaLinha para saber qual é a última linha da matriz. Comprimento total de linhas -1.
        int ultimaLinha = matriz.length - 1;

        // Vou imprimir apenas as colunas (nome e rating) assumindo que as colunas da matriz não vão mudar, contudo sempre
        // que adicionarem linhas à matriz, os valores impressos serão atualizados para a última linha (-1).
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("        " + matriz[ultimaLinha][1] + " - " + matriz[ultimaLinha][2]);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    public static void quiz(String caminhoQuiz) throws FileNotFoundException {

        Scanner ficheiro = new Scanner(new File(caminhoQuiz));
        Scanner input = new Scanner(System.in);

        int totalPontuacao = 0;
        int totalPerguntas = 0;

        // Ignorar a primeira linha (cabeçalho)
        if (ficheiro.hasNextLine()) {
            ficheiro.nextLine();
        }

        while (ficheiro.hasNextLine()) {
            String linha = ficheiro.nextLine();
            String[] linhaDividida = linha.split(";");

            String pergunta = linhaDividida[0];
            String[] opcoes = new String[4];
            opcoes[0] = linhaDividida[1];
            opcoes[1] = linhaDividida[2];
            opcoes[2] = linhaDividida[3];
            opcoes[3] = linhaDividida[4];

            int respostaCerta = Integer.parseInt(linhaDividida[5]);

            System.out.println("" + pergunta);
            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }

            System.out.print("> Choose the correct option: ");
            int resposta = input.nextInt();
            input.nextLine();

            if (resposta == respostaCerta) {
                System.out.println("✅ Well done, correct!\n");
                totalPontuacao++;
            } else {
                System.out.println("❌ Sorry, wrong answer. The right one was: " + opcoes[respostaCerta - 1] + "\n");
            }

            totalPerguntas++;

        }
        ficheiro.close();

            // Criei dois tipos de mensagens após responder as perguntas todas do quiz. Se a pontuação for igual ou inferior a 3 será impresso uma mensagem de incentivo.
            if (totalPontuacao <= 3) {
                System.out.println(("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"));
                System.out.println(" \uD83C\uDFAF Still learning — more movies await! \uD83C\uDFAF");

            //  Caso contrário, se a pontuação for superior a 3, será impresso uma mensagem de felicitação pelo bom desempenho.
            } else {
                System.out.println(("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"));
                System.out.println(" \uD83C\uDFC6 Impressive! You're a true movie buff! \uD83C\uDFC6");

            }

            // Aqui peço para imprimir o resultado, ou seja, o total de respostas certas (totalPontuação) em relação ao total de perguntas.
        System.out.println("         Your final score is: " + totalPontuacao + "/" + totalPerguntas);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

    }

    public static void imprimirCategoriaEstudio(String[][] matriz) {
        Scanner input = new Scanner(System.in);

        // Usei uma função que já tinha para listar todos os estúdios da matriz para facilitar a escolha do utilizador.
        Menu_Admin.imprimirEstudiosUnicos(matriz);

        int totalFilmes = matriz.length - 1;
        String[] categorias = new String[totalFilmes];
        int qtdCategorias;

        String procurarEstudio;
        boolean encontrou;

        do {
            System.out.print("\n \uD83C\uDFAF Choose a studio: ");
            procurarEstudio = input.nextLine();

            encontrou = false;
            qtdCategorias = 0;

            for (int i = 1; i < matriz.length; i++) {
                String estudio = matriz[i][5];
                String categoria = matriz[i][7];

                if (estudio.equalsIgnoreCase(procurarEstudio)) {
                    encontrou = true;

                    boolean existe = false;
                    for (int j = 0; j < qtdCategorias; j++) {
                        if (categorias[j].equalsIgnoreCase(categoria)) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        categorias[qtdCategorias] = categoria;
                        qtdCategorias++;
                    }
                }
            }
            if (!encontrou) {
                System.out.println(" \u274C No movies found for this studio. Please try again.\u274C");
            }

        } while (!encontrou);

        System.out.println("\n***** " + procurarEstudio + " *****\n");

        // Imprime filmes agrupados por categoria
        for (int c = 0; c < qtdCategorias; c++) {
            System.out.println("__ " + categorias[c] + " __");
            for (int i = 1; i < matriz.length; i++) {
                String estudio = matriz[i][5];
                String categoria = matriz[i][7];
                String titulo = matriz[i][1];

                if (estudio.equalsIgnoreCase(procurarEstudio) && categoria.equalsIgnoreCase(categorias[c])) {
                    System.out.println(titulo);
                }
            }
            System.out.println();
        }
    }

    public static void imprimirFilmeCategoria(String[][] matriz) {
        Scanner input = new Scanner(System.in);

        int totalFilmes = matriz.length - 1;
        String[] categorias = new String[totalFilmes];
        int qtdCategorias = 0;

        // Coletar categorias únicas
        for (int i = 1; i < matriz.length; i++) {
            String categoria = matriz[i][7];
            boolean existe = false;
            for (int j = 0; j < qtdCategorias; j++) {
                if (categorias[j].equalsIgnoreCase(categoria)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                categorias[qtdCategorias] = categoria;
                qtdCategorias++;
            }
        }

        // Mostrar categorias para o usuário escolher
        System.out.println("\n*-*-* LIST OF AVAILABLE CATEGORIES *-*-*\n");
        for (int i = 0; i < qtdCategorias; i++) {
            System.out.println((i + 1) + " - " + categorias[i]);
        }
        System.out.println("20 - Return to main menu");

        int escolha = -1;
        do {
            System.out.print("\n\uD83C\uDFAF Choose a category: ");
            String entrada = input.nextLine();

            try {
                escolha = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            if (escolha == 20) {
                return;
            }

            if (escolha < 1 || escolha > qtdCategorias) {
                System.out.println("Invalid category number. Try again.");
                escolha = -1;
            }
        } while (escolha == -1);

        String categoriaEscolhida = categorias[escolha - 1];

        // Para essa categoria, mostrar estúdios e filmes
        // Vamos agrupar os filmes por estúdio:
        String[] estudios = new String[totalFilmes];
        int qtdEstudios = 0;

        // Primeiro coletar estúdios que tenham filmes nessa categoria
        for (int i = 1; i < matriz.length; i++) {
            String estudio = matriz[i][5];
            String categoria = matriz[i][7];
            if (categoria.equalsIgnoreCase(categoriaEscolhida)) {
                boolean existe = false;
                for (int j = 0; j < qtdEstudios; j++) {
                    if (estudios[j].equalsIgnoreCase(estudio)) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    estudios[qtdEstudios] = estudio;
                    qtdEstudios++;
                }
            }
        }

        // Agora para cada estúdio, listar os filmes na categoria escolhida
        for (int e = 0; e < qtdEstudios; e++) {
            System.out.println("\n**** " + estudios[e] + " ****");
            for (int i = 1; i < matriz.length; i++) {
                String estudio = matriz[i][5];
                String categoria = matriz[i][7];
                String titulo = matriz[i][1];
                if (estudio.equalsIgnoreCase(estudios[e]) && categoria.equalsIgnoreCase(categoriaEscolhida)) {
                    System.out.println("  > " + titulo);
                }
            }
            System.out.println();
        }
    }



    public static void menuCliente(String[][] matriz, String caminhoFilmes) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {
            // De forma a ser criativo, adicionei ícones (códigos Unicode) relacionados com o tema cinema.
            System.out.println("\n\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC THE MOVIE UNIVERSE IMDV \uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC\n");
            System.out.println("\u2B50 1. Movie List");
            System.out.println("\uD83C\uDFA8 2. Graphic Art");
            System.out.println("\uD83C\uDFC6 3. Best Movie Studio");
            System.out.println("\uD83D\uDC80 4. Worst Movie Studio");
            System.out.println("\uD83D\uDCDD 5. Latest Review");
            System.out.println("\uD83C\uDFB2 6. Play Quiz");
            System.out.println("\uD83C\uDFAD 7. Movies By Studios");
            System.out.println("\uD83D\uDCC2 8. Movies By Category");
            System.out.println("\u274C 0. Exit\n");

            System.out.print("> Select an option: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("\u2B50\u2B50\u2B50\u2B50 MOVIE LIST \u2B50\u2B50\u2B50\u2B50\n");
                    Menu_Admin.imprimirMatriz(matriz);
                    break;

                case 2:
                    int opcaoMenuArtes;

                    // Criação de um submenu para a opção Arte Gráfica
                    do {
                        System.out.println("\n\uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8 MOVIE GRAPHICS \uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8\uD83C\uDFA8\n");

                        System.out.println("\uD83E\uDDD9\u200D\u2642\uFE0F 1. Harry Potter");
                        System.out.println("\uD83D\uDE80 2. Interstellar");
                        System.out.println("\uD83E\uDDDD\u200D\u2642\uFE0F 3. Lord Of The Rings");
                        System.out.println("\u2728 4. Star Wars");
                        System.out.println("\u274C 5. Back to main menu\n");

                        System.out.print("> Select an option: ");

                        opcaoMenuArtes = input.nextInt();
                        input.nextLine(); // Limpar o buffer

                        String caminhoArte = "";

                        // Associar imagem à opção anterior do cliente
                        switch (opcaoMenuArtes) {
                            case 1: caminhoArte = "IMDV/CatalogoGrafico/HarryPotter.txt"; break;
                            case 2: caminhoArte = "IMDV/CatalogoGrafico/Interstellar.txt"; break;
                            case 3: caminhoArte = "IMDV/CatalogoGrafico/LordOfTheRings.txt"; break;
                            case 4: caminhoArte = "IMDV/CatalogoGrafico/StarWars.txt"; break;
                            case 5: System.out.println("Return to previous menu"); break;
                            default: System.out.println("Invalid option. Please try again."); break;
                        }

                        if (!caminhoArte.isEmpty()) {
                            Menu_Admin.imprimirFicheiro(caminhoArte);
                        }

                    } while (opcaoMenuArtes != 5);

                    break;


                case 3:
                    System.out.println("    \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6  BEST MOVIE STUDIO \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6\n");
                    melhorRating(matriz);

                    break;

                case 4:
                    System.out.println("    \uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80  WORST MOVIE STUDIO \uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\n");
                    piorRating(matriz);

                    break;

                case 5:
                    System.out.println("    \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD LATEST REVIEW \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\n");
                    ultimoReview(matriz);

                    break;
                case 6:
                    System.out.println("\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2 PLAY QUIZ \uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\n");
                    String caminhoQuiz = "IMDV/IMDV_Quiz2.csv";
                    quiz(caminhoQuiz);

                    break;
                case 7:
                    System.out.println("\uD83C\uDFAD\uD83C\uDFAD\uD83C\uDFAD\uD83C\uDFAD MOVIES BY STUDIOS \uD83C\uDFAD\uD83C\uDFAD\uD83C\uDFAD\uD83C\uDFAD");
                    imprimirCategoriaEstudio(matriz);

                    break;
                case 8:
                    System.out.println("\uD83D\uDCC2\uD83D\uDCC2\uD83D\uDCC2\uD83D\uDCC2 MOVIES BY CATEGORY \uD83D\uDCC2\uD83D\uDCC2\uD83D\uDCC2\uD83D\uDCC2");
                    imprimirFilmeCategoria(matriz);

                    break;

                case 0:
                    System.out.println("              \uD83D\uDE0A\uD83D\uDE0A BYE! COME BACK SOON! \uD83D\uDE0A\uD83D\uDE0A");
                    Menu_Admin.imprimirFicheiro("IMDV/IMDV_Copyright.txt");

                    break;

                default:
                    System.out.println("\u26D4 INVALID OPTION \u26D4");

                    break;

            }

        } while (opcao != 0);
    }

    public static void main(String[] args) throws FileNotFoundException {

        String caminhoFilmes= "IMDV/IMDV.csv";

        String caminhoQuiz = "IMDV/IMDV_Quiz2.csv";

        String[][] matriz = Menu_Admin.listaParaMatriz(caminhoFilmes);

        // Menu principal do Cliente - The Movie Universe IMDV
        menuCliente(matriz, caminhoFilmes);

    }
}
