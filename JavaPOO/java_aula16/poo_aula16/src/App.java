public class App {
    public static void main(String[] args) throws Exception {
        // if (args.length > 0) {
        //     int[] intArgs = new int[args.length];
        //     for (int i = 0; i < intArgs.length; i++){
        //         try {
        //             intArgs[i] = Integer.parseInt(args[i]);
        //             System.out.format("Argumento inteiro %d = %d%n", i, intArgs[i]);
        //         } catch (NumberFormatException e) {
        //             System.err.println("Argumento " + args[i] + " deve ser um inteiro.");
        //             System.exit(1);
        //         }
        //     }
        // }

         if (args.length == 3) {
            int valor1 = 0, valor2 = 0, resultado = 0;
            char operador = '+';
            try {
                valor1 = Integer.parseInt(args[0]);
                operador = args[1].charAt(0);
                valor2 = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argumentos devem ser um inteiro, um caractere e outro inteiro.");
                System.exit(1);
            }
         
         switch (operador) {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case 'x':
                resultado = valor1 * valor2;
                break;
            case '/':
                resultado = valor1 / valor2;
                break;
            default:
            System.err.format("O operador %c não foi reconhecido.%n", operador);
            System.exit(1);
            
            }

            System.out.format("Resultado = %d%n", resultado);  

        } else {
            System.err.println("Esse programa requer 3 argumentos.");
            System.exit(1);
        }
    }
}