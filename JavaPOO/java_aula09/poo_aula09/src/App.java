import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App {

    //method de limpar a tela
    public static void clearSrcreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        
        
        // clearSrcreen();
        // // Scanner ("Objeto scan do method Scanner capta os dados inseridos do teclado")
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Digite o valor do primeiro lado: ");
        // double lado1 = scan.nextDouble();
        // System.out.println("Digite o valor do segundo lado: ");
        // double lado2 = scan.nextDouble();
        // double area = lado1 * lado2;
        // System.out.format("A area do retângulo de lados %f e %f e %f .%n",
        // lado1, lado2, area);


        // clearSrcreen();
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Digite o primeiro valor: ");
        // double valor1 = scan.nextDouble();
        // System.out.println("Digite o segundo valor: ");
        // double valor2 = scan.nextDouble();
        // double soma = valor1 + valor2;
        // double sub = valor1 - valor2;
        // double mult = valor1 * valor2;
        // double div = valor1 / valor2;
        // System.out.format("Soma: %f%nSubtracao: %f%nMultiplicacao: %f%nDivisao: %f%n",
        //     soma, sub, mult, div);
        // scan.close();
        

        // clearSrcreen();
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Digite o valor limite: ");
        // int valorLimite = scan.nextInt();
        // int qtdePrimos = 0;
        // int valorAtual = 2;
        // while (valorAtual <= valorLimite){
        //     boolean ehPrimo = true;
        //     for (int i = 2; i < valorAtual; i++) {
        //         if (valorAtual % i == 0) {
        //             ehPrimo = false;
        //             break;
        //         }
        //     }
        //     if (ehPrimo) {
        //         qtdePrimos++;
        //     }
        //     valorAtual++;
        // }
        // System.out.format("A quantidade de numeros primos ate %d é de %d.%n",
        //     valorLimite, qtdePrimos);
        // scan.close();

        // clearSrcreen();
        // //i=(ay.bz)-(az.by)
        // //j=(az.bx)-(ax.bz)
        // //k=(ax.by)-(ay.bx)
        // int x = 0;
        // int y = 1;
        // int z = 2;
        // int[] vA = {1, 3, 1};
        // int[] vB = {2, 2, 3};
        // int[] produto = new int[3];
        // produto[x] = vA[y]*vB[z] - vA[z]*vB[y]; // 3 * 3 - 1 * 2               produto x = 7 
        // produto[y] = vA[z]*vB[x] - vA[x]*vB[z]; // 1 * 2 - 1 * 3               produto y = 1
        // produto[z] = vA[x]*vB[y] - vA[y]*vB[x]; // produto z = 4
        // System.out.format("Produto vetorial: (%d, %d, %d)", produto[x], produto[y], produto[z]);

        // clearSrcreen();
        // Scanner scan = new Scanner(System.in);
        // int[] vetor = new int[5];
        // for (int i = 0; i < vetor.length; i++) {
        //     System.out.format("Digite o valor do elemento %d do vetor:", i);
        //     int valor = scan.nextInt();
        //     vetor[i] = valor;
        // }
        // int maior = Integer.MIN_VALUE;
        // System.out.println("T");
        // int menor = Integer.MAX_VALUE;
        // int soma = 0;
        // for (int elemento : vetor){
        //     soma += elemento;
        //     if (elemento > maior) maior = elemento;
        //     if (elemento < menor) menor = elemento;
        // }
        // double media = soma / vetor.length;
        // System.out.format("Maior: %d%nMenor : %d%nMedia: %f%n", maior, menor, media);
        // System.out.println("Valores pares: ");
        // for (int elemento : vetor){
        //     if (elemento % 2 == 0) System.out.format("%d, ", elemento);
        // }
        // System.out.println();
        // System.out.println("Valores impares: ");
        // for (int elemento : vetor) {
        //     if (elemento % 2 != 0) System.out.format("%d, ", elemento);
        // }
        // System.out.println();
        // scan.close();

        
        // clearSrcreen();
        // Scanner scan = new Scanner(System.in);
        // final int qtdeAlunos = 5;
        // double[] notasA = new double[qtdeAlunos];
        // double[] notasB = new double[qtdeAlunos];
        // double[] medias = new double[qtdeAlunos];
        // for (int i = 0; i < qtdeAlunos; i++) {
        //     System.out.format("Digite a %d nota do aluno A: ", i+1);
        //     double valor = scan.nextDouble();
        //     notasA[i] = valor;   
        // }
        // System.out.println();
        // for (int i = 0; i < qtdeAlunos; i++) {
        //     System.out.format("Digite a %d nota do aluno B: ", i+1);
        //     double valor = scan.nextDouble();
        //     notasB[i] = valor;
        // }
        // System.out.println();
        // for (int i = 0; i < medias.length; i++){
        //     medias[i] = (notasA[i] + notasB[i]) / 2;
        // }
        // for (int i = 0; i < medias.length; i++){
        //     System.out.format("A média do aluno %d foi %f.%n", i+1, medias[i]);
        // }
        // scan.close();

        // clearSrcreen();
        // Scanner scan = new Scanner(System.in);

        // System.out.println("X do ponto 1: ");
        // double x1 = scan.nextDouble();
        // System.out.println("Y do ponto 1: ");
        // double y1 = scan.nextDouble();

        // System.out.println("X do ponto 2: ");
        // double x2 = scan.nextDouble();
        // System.out.println("Y do ponto 2: ");
        // double y2 = scan.nextDouble();
        
        // //Math.sqrt = retorna a raiz quadrada positiva corretamente arredondada de um valor double    
        // double distancia = Math.sqrt(
        //     //Math.pow = Esse método retorna o valor do primeiro argumento elevado à potência do segundo argumento.
        //     Math.pow(x2-x1, 2)+
        //     Math.pow(y2-y1, 2)

        // );

        // System.out.println("A distância entre os pontos é "+ distancia);

        // clearSrcreen();
        // Scanner scan = new Scanner(System.in);

        // System.out.println("X do ponto: ");
        // double x = scan.nextDouble();
        // System.out.println("Y do ponto");
        // double y = scan.nextDouble();

        // double angRad = Math.atan2(y, x); 
        // double angDeg = (angRad * 180)/Math.PI;

        // System.out.format("O ângulo e de %f graus.%n", angDeg);

        // scan.close();

        clearSrcreen();
        Scanner scan = new Scanner(System.in);
        Random gerador = new Random();
        int valorSorteado = gerador.nextInt(11);
        int tentativas = 0;
        int valorDigitado = - 1;
        do {
            System.out.println("Digite seu Palpite: ");
            valorDigitado = scan.nextInt();
            if (valorDigitado != valorSorteado) {
                System.out.println("Você errou... Tente novamente");
                Thread.sleep(1000);
                clearSrcreen();
            }
            tentativas++;
        } while (valorDigitado != valorSorteado);
        System.out.format("Você acertou em %d tentativas.%n", tentativas);
        scan.close();



       


        
    }
}
