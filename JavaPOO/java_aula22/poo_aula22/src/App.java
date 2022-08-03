import java.io.IOException;
import java.net.ServerSocket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void limpaTela() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        limpaTela();
        exemplo5();
    }

    public static void exemplo1() {
        try {
            String texto = null;
            int tamanho = texto.length();
            System.out.printf("\nTamanho: %d\n", tamanho);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Depois da exceção...");
    }

    public static void exemplo2() {
        try {
            int[] vetor = {0, 1, 2, 3, 4};
            System.out.printf("\nElemento  5: %d\n", vetor[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Depois da exceção...");
    }

    public static void exemplo3(){
        try{
            Scanner leitor = new Scanner(System.in);
            System.out.print("Primeiro número:");
            int n1 = leitor.nextInt();
            System.out.print("Segundo número:");
            int n2  = leitor.nextInt();
            double res = n1  / n2;
            System.out.printf("\nResultado: %.2f\n", res);
            leitor.close();
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Depois da exceção...");
    }

    public static void exemplo4() {

        boolean novoCalculo = false;
        Scanner leitor = new  Scanner(System.in);
        do {
            try{
                System.out.print("Primeiro número: ");
                int n1 = leitor.nextInt();
                System.out.print("Segundo  número: ");
                int n2 = leitor.nextInt();
                double res = n1 / n2;
                System.out.printf("\nResultado: %.2f\n", res);
            } catch (ArithmeticException e) {
                System.out.println("Não é possível dividir por zero");
            } catch (InputMismatchException e) {
                System.out.println("Numero inteiro  inválido.");
            } catch (Exception e) {
                System.out.println("Ocorreu uma exceção imprevista.");
            }
            leitor.nextLine();
            System.out.print("\nNovo cálculo (S/N):");
            novoCalculo = leitor.nextLine().toUpperCase().equals("S");
        }while (novoCalculo);
        leitor.close();

        System.out.println("Depois da exceção...");
    }

    public static void exemplo5() throws IOException {
        Scanner leitor = new Scanner(System.in);
        ServerSocket ss1 = new ServerSocket(7777);
        System.out.println("Porta aberta com sucesso #1.");

        try {
            System.out.print("Digite um numero: ");
            int x = leitor.nextInt();
            System.out.println("Número digitado: "+ x);
            ss1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ss1.close();
        }

        ServerSocket ss2 = new ServerSocket(7777);
        System.out.println("Porta aberta com sucesso #2.");
        ss2.close();

        leitor.close();
    }
}
