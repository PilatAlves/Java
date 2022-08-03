import java.io.IOException;
import java.util.Scanner;



public class App {
    
    public static void limparTela() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
    public static void main(String[] args) throws Exception {
        
        limparTela();
        
        // largura e comprimento da sala
        int LARG = 8;
        int COMP = 10;

        // matriz que representa as poltronas do cinema
        int sala[][] = new int[LARG][COMP];

        InicializaPoltronas(sala);

        // MENU
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        while (option != 4) {
            String[] options = { "1 - Reservar", "2 - Comprar", "3 - Cancelar", "4 - Sair" };

            // imprimir salas
            ImprimeSala(sala);

            // invovar a funçao de impressão de menu
            printMenu(options);

            // depois de exibir o menu le a opção escolhida e salva em option
            try {
                option = scan.nextInt();
                switch (option) {
                    case 1:
                        reservar(sala);
                        break;
                    case 2:
                        //comprar(sala);
                        break;
                    case 3:
                        //cancelar;
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                }
            } catch (Exception ex) {
                System.out.println("Por favor, entre com um inteiro entre 1 e " + options.length);
                scan.next();
            }

        }

        scan.close();

        
    }

    public static void InicializaPoltronas(int sala[][]) {
        // inicializa as poltronas do cinema com o número da poltrona
        int num = 1;
        for (int lin = 0; lin < sala.length; lin++) {
            for (int col = 0; col < sala[lin].length; col++) {
                sala[lin][col] = num;
                num++;
            }
        }
    }

    public static void ImprimeSala(int sala[][]) {
        // imprime as poltronas do cinema
        System.out.println();
        System.out.println("********************* CINEMA TOP *************************");
        for (int lin = 0; lin < sala.length; lin++) {
            for (int col = 0; col < sala[lin].length; col++) {
                if (sala[lin][col] == -1) {
               
                    System.out.print("[RES] "); // poltrona reservada
                    
                } else if (sala[lin][col] == -2) {
                 
                    System.out.print("[VEN] "); // poltrona vendida
                    
                } else {
                    System.out.printf("[%03d] ", sala[lin][col]);
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    // imprimiri menu
    public static void printMenu(String[] options) {
        // enhanced for
        for (String op : options) {
            System.out.println(op);
        }
        System.out.print("Escolha uma opcao: ");
    }

    // funcao para reservar cadeira
    public static void reservar(int sala[][]) {
        Scanner scan = new Scanner(System.in);
        InicializaPoltronas(sala);
        ImprimeSala(sala);
        System.out.println("SISTEMA DE RESERVA ------------- ");
        System.out.print("Qual o número da poltrona: ");
        int numPol = scan.nextInt();
        numPol--;
        scan.close();

    }

         // verificar se a poltrona é valida
    private static int poltronares;

    public static boolean EstaLivre(int sala[][], int numPoltrona) {

        boolean livre = false;

        for (int lin = 0; lin < sala.length; lin++) {
            for (int col = 0; col < sala[lin].length; col++) {
                if(sala[lin][col] == numPoltrona) {
                    livre = true;
                }
            }
        }

        return livre;
    }

    

}
