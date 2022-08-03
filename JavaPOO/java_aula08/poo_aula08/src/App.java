import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 

    }
    public static void main(String[] args) throws Exception {
        
        // //cálculo da média do vetor1
        // int[] vetor1 = {13, 25, 43, 78, 33};
        // int somaVetor1 = 0;
        // for (int i = 0; i < vetor1.length; i++){
        //     somaVetor1 += vetor1[i];
        // }
        // System.out.println("A média do vetor1 é " + 
        //     (float)somaVetor1/vetor1.length);

        // //cálculo da média do vetor2
        // int[] vetor2 = {54,82,26,51,26};
        // int somaVetor2 = 0;
        // //foreach (var : var1)
        // for (int valor : vetor2){
        //         somaVetor2 += valor;
        // }
        // System.out.println("A media do vetor2 e " +
        //     (float)somaVetor2/vetor2.length);

        // //vetor1 na ordem inversa
        // int[] vetor1 = {13, 25, 43, 78, 33};
        // System.out.println("Vetor1 na ordem inversa:");
        // for (int i = vetor1.length-1; i >= 0; i--) {
        //     System.out.format("%d, ", vetor1[i]);
        // }
        // System.out.println();

        // // soma de dois vetores
        // int[] vetor1 = {13, 25, 43, 78, 33};
        // int[] vetor2 = {54, 82, 26, 51, 26};
        // int[] vetorSoma = new int[5];
        // for (int i = 0; i < vetor1.length; i++) {
        //     vetorSoma[i] = vetor1[i] + vetor2[i];
        // }
        // for (int valor : vetorSoma){
        //     System.out.format("%d, ", valor);
        // }
        // System.out.println();

        // //exibição de menu console
        // int op;
        // Scanner scan = new Scanner(System.in);
        // do {
        //     clearScreen();
        //     System.out.println("1 - Jogar");
        //     System.out.println("2 - Sair");
        //     System.out.println("Opcao Desejada: ");
        //     op = scan.nextInt();
        //     switch (op) {
        //         case 1:
        //             System.out.println("Jogando...");
        //             Thread.sleep(2000);
        //             System.out.println("Acabou o jogo!");
        //             Thread.sleep(1000);
        //             break;  
        //         case 2:
        //             System.out.println("Saindo...");
        //             Thread.sleep(1000);
        //             break;
        //         default:
        //             System.out.println("Opcao invalida");
        //             Thread.sleep(2000);
        //             break;
        //     }
        // } while (op != 2);
        // scan.close();
        // System.out.println("Saiu!");

        //cálculo dos N primeiros números primos
        int[] primos = new int[1000];
        int qtdePrimos = 0;
        int valorAtual = 1;
        while (qtdePrimos < primos.length){
            boolean ehPrimo = true;
            for (int i = 2; i < valorAtual; i++) {
                if (valorAtual % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }
            if(ehPrimo) {
                qtdePrimos++;
                primos[qtdePrimos-1] = valorAtual;
                System.out.println("Número primo encontrado: " + valorAtual);
            }
            valorAtual++;
        }


    }
      
}
