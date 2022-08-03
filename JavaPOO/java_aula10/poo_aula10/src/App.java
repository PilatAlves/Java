import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        clearScreen();
        // int[] vetor1 = {13, 25, 43, 78, 33};
        // double res = obterMediaVetor(vetor1);
        // System.out.println(res);

        // int[] vetor2 = {54, 82, 26, 51, 26};
        // double res2 = obterMediaVetor(vetor2);
        // System.out.println(res2);

        // int[] vetorOriginal = {13, 25, 43, 78, 33};
        // int[] vetorInvertido = obterVetorInvertido(vetorOriginal);
        // mostrarVetor(vetorInvertido);

        // int[] vetorA = {2, 1, 4, 1, 6};
        // int[] vetorB = {1, 3, 1, 5, 1};
        // int[] vetorSoma = obterSomaVetores(vetorA, vetorB);
        // mostrarVetor(vetorSoma);

        // processarMenu();

        // int[] primos = computarVetorDePrimos(10);
        // mostrarVetor(primos);
        listarProdutos();
     
    }
        
    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }


    public static double obterMediaVetor(int[] vetor){
        int somaVetor1 = 0;
        for (int i = 0; i < vetor.length; i++){
            somaVetor1 += vetor[i];
        }
        double resultado = (float)somaVetor1/vetor.length;
        return resultado;
   }

   public static int[] obterVetorInvertido(int[] vetor){
    int[] vetorInvertido = new int[vetor.length];
    int iVetorInvertido = 0;
    for (int i = vetor.length-1; i >= 0; i--) {
        vetorInvertido[iVetorInvertido] = vetor[i];
        iVetorInvertido++;
    }
    return vetorInvertido;   
   }
   
   public static void mostrarVetor(int[] vetor){
        for (int valor : vetor){
            System.out.print(valor + ", ");
        }
   }

   public static int[] obterSomaVetores(int[] vetor1, int[] vetor2) {
    int[] vetorSoma = new int[vetor1.length];
    for (int i = 0; i < vetorSoma.length; i++) {
        vetorSoma[i] = vetor1[i] + vetor2[i];
    }
    return vetorSoma;
   }

//    public static void monstrarMenu() throws InterruptedException, IOException {
//     int op;
//     Scanner scan = new Scanner(System.in);
//     do {
//         clearScreen();
//         System.out.println("1 - Jogar");
//         System.out.println("2 - Sair");
//         System.out.println("Opção desejada: ");
//         op = scan.nextInt();
//         switch (op) {
//             case 1:
//                 System.out.println("Jogando...");
//                 Thread.sleep(2000);
//                 System.out.println("Acabou o jogo!");
//                 Thread.sleep(1000);
//                 break;
//             case 2:
//                 System.out.println("Saindo...");
//                 Thread.sleep(1000);
//                 break;
//             default:
//                 System.out.println("Opção inválida!");
//                 Thread.sleep(2000);
//                 break; 

//         }
//     }while (op != 2);
//     scan.close();
//     System.out.println("Saiu!");
//    }



   public static int obterOpcaoDoMenu(Scanner scan)  {
    System.out.println("1 - Jogar");
    System.out.println("2 - Sair");
    System.out.println("Opção desejada:");
    int opcaoDesejada = scan.nextInt();
    return opcaoDesejada;
   }

   public static void executarOpcaoDoMenu(int opcao) throws InterruptedException {
    switch (opcao) {
        case 1:
            System.out.println("Jogando...");
            executarJogo();
            System.out.println("Acabou o jogo!");
            Thread.sleep(1000);
            break;
        case 2:
            System.out.println("Saindo...");
            Thread.sleep(1000);
            break;
        default:
            System.out.println("Opção inválida!");
            Thread.sleep(2000);
            break; 
        }

    }

    public static void executarJogo() throws InterruptedException {
        for (int i = 1; i <= 5; i++){
            Thread.sleep(1000);
            System.out.format("Passou da fase %d...%n", i);
        }
        System.out.println("Você Venceu");
        Thread.sleep(1000);
    }  
    
    public static void processarMenu() throws InterruptedException, IOException{
        int opcao;
        Scanner scan = new Scanner(System.in);
        do {
            clearScreen();
            opcao = obterOpcaoDoMenu(scan);
            executarOpcaoDoMenu(opcao);
        } while (opcao != 2);
        scan.close();
        System.out.println("Programa finalizado.");
    }

    public static int[] computarVetorDePrimos(int tamanho) {
        int[] primos = new int[tamanho];
        int qtdePrimos = 0;
        int valorAtual = 1;
        while (qtdePrimos < primos.length) {
            boolean ehPrimo = true;
            for (int i = 2; i < valorAtual; i++){
                if (valorAtual % i == 0){
                    ehPrimo = false;
                    break;
                }
            }
            if (ehPrimo) {
                qtdePrimos++;
                primos[qtdePrimos-1] = valorAtual;
            }
            valorAtual++;
        } 
        return primos;
    }

    public static void listarProdutos() {
        String[] nomes = new String[]
        {"Abacaxi", "Banana", "Laranja", "Morango",
        "Uva"};
        double[] precos =  new double[]
            {4.25, 2.33, 2.99, 7.89, 11.79};
        int[] qtdes = new int[]
            {432, 26, 365, 811, 712};
        
        System.out.printf("%-10s|%7s | %7s%n", 
            "Nome", "Preço", "Estoque");
        System.out.println("----------------------------");
        for (int i = 0; i < nomes.length; i++){
            System.out.printf("%-10s|%7.2f | %07d%n",
                nomes[i], precos[i], qtdes[i]);
        }
    }
    
    
}
